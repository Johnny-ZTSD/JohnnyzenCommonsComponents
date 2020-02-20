package cn.johnnyzen.util.database;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.yaml.snakeyaml.Yaml;

import java.sql.SQLException;
import java.util.*;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2019/6/24  13:51:47
 * @Description:  基于DBUtils的数据库操纵工具
 *      特点
 *          + 脱离Spring(IOC) : 完全独立
 *          + 又与Spring相关联 : 均利用application.yml 这一文件进行数据库资源配置
 */

public class DatabaseUtil {
    private static final Logger logger = Logger.getLogger(DatabaseUtil.class.getName());

    private static String logPrefix = null;

    public static DataSource getDataSourceOfDatabasePool() {
        logPrefix = "[DatabaseUtil.getDataSourceOfDatabasePool] ";
        /* step1 读取yml配置文件
         * + 参考文献
         *  + [java读取yaml配置文件](https://www.cnblogs.com/yinchh/p/10407986.html)
         */
        Yaml yaml = new Yaml();
        InputStream in = Thread.class.getResourceAsStream("/application.yml");//文件路径是相对类目录(src/main/java)的相对路径
        Map<String, Object> map = yaml.loadAs(in, Map.class);
        Map<String,String> dbConfig = (Map<String, String>) ((Map<String, Object>) map.get("spring")).get("datasource");
//        System.out.print("spring:"+map.get("spring"));//((Map<String, Object>) map.get("server")).get("port").toString();
        /**
         * step2 初始化C3P0数据库连接池 pool
         */
        ComboPooledDataSource pool = new ComboPooledDataSource();
        try {
            pool.setDriverClass(dbConfig.get("driver-class-name"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
            logger.warning(logPrefix + "Not Found Driver Config of 'driver-class-name' for application.yml");
        }
        pool.setUser(dbConfig.get("username"));
        pool.setPassword(dbConfig.get("password"));
        pool.setJdbcUrl(dbConfig.get("url"));
        return pool;
    }

    /**
     * 查询一条实体记录
     * + [demo]
     *  + String sql = "select * from tb_article limit 0,1";
     *    DatabaseUtil databaseUtil = new DatabaseUtil();
     *    Object []params = {};
     *    System.out.print(DatabaseUtil.findOne(sql,params,Article.class));
     * @param sql
     * @param clazz
     * @param <T>
     * @return T
     * @throws PropertyVetoException
     * @throws IOException
     * @throws SQLException
     */
    public static<T> T findOne(String sql,Object [] params, Class<T> clazz) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(getDataSourceOfDatabasePool());
        T t = (T) queryRunner.query(sql, params, new BeanHandler(clazz,new BasicRowProcessor(new DBUtilsBeanProcessor(new HumpMatcher())) )); //数据字段应自觉遵守自定义的驼峰命名法策略
        return t;
    }

    /**
     * 查询N条实体记录(集合)
     * + [demo]
     *  + String sql = "select * from tb_article limit 1,5";
     *    DatabaseUtil databaseUtil = new DatabaseUtil();
     *    Object []params = {};
     *    Print.print(DatabaseUtil.findList(sql, params, Article.class));
     * @param sql
     * @param clazz
     * @param <T>
     * @return List<T>
     * @throws PropertyVetoException
     * @throws IOException
     * @throws SQLException
     */
    public static<T> List<T> findList(String sql,Class<T> clazz) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(getDataSourceOfDatabasePool());
        List<T> list = (List<T>)queryRunner.query(sql, new BeanListHandler(clazz, new BasicRowProcessor(new DBUtilsBeanProcessor(new HumpMatcher())) ));
        return list;
    }
}
