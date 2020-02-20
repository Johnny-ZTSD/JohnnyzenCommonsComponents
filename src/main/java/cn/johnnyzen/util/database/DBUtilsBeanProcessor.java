package cn.johnnyzen.util.database;

import java.beans.PropertyDescriptor;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;

import org.apache.commons.dbutils.BeanProcessor;

/**
 * 原作者 https://blog.csdn.net/jiutianhe/article/details/40827899
 */
public class DBUtilsBeanProcessor extends BeanProcessor {
    private Matcher matcher;

    public DBUtilsBeanProcessor() {
    }

    public DBUtilsBeanProcessor(Matcher matcher) {
        this.matcher = matcher;
    }

    public Matcher getMatcher() {
        return matcher;
    }

    public void setMatcher(Matcher matcher) {
        this.matcher = matcher;
    }

    /**
     * 重写BeanProcessor的实现,使用策略模式
     */
    protected int[] mapColumnsToProperties(ResultSetMetaData rsmd,
                                           PropertyDescriptor[] props) throws SQLException {
        if (matcher == null)
            throw new IllegalStateException("Matcher must be setted!");
        int cols = rsmd.getColumnCount();
        int columnToProperty[] = new int[cols + 1];
        Arrays.fill(columnToProperty, PROPERTY_NOT_FOUND);
        for (int col = 1; col <= cols; col++) {
            String columnName = rsmd.getColumnLabel(col);
            if (null == columnName || 0 == columnName.length()) {
                columnName = rsmd.getColumnName(col);
            }
            for (int i = 0; i < props.length; i++) {
                if (matcher.match(columnName, props[i].getName())) {// 与BeanProcessor不同的地方
                    columnToProperty[col] = i;
                    break;
                }
            }
        }

        return columnToProperty;
    }
}
