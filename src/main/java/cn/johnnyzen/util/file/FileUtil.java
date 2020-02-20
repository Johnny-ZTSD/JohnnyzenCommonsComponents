package cn.johnnyzen.util.file;

import java.io.*;
import java.util.logging.Logger;

public class FileUtil {
    private static final Logger logger = Logger.getLogger(FileUtil.class.getName());

    private static String logPrefix = null;

    public static void saveFile(byte[] file,String filePath,String fileName) throws IOException {
        File targetFile=new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * 从输入流中获取文本内容
     * + demo
     *  + InputStream in = Thread.class.getResourceAsStream("/application.yml");
     * + read(byte[] b)
     *  + 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
     *  + 以整数形式返回实际读取的字节数。
     * @param in
     * @return
     */
    public static String readFile(InputStream in) throws IOException {
        StringBuilder fileText = new StringBuilder();
        byte b[] = new byte[1024];     //创建合适文件大小的数组
        int len = 0 ;
        while((len = in.read(b))!=-1){// 还有内容，文件没有读完
            fileText.append(new String(b,0, len)); // 把byte数组变为字符串输出
//            System.out.print(new String(b,0, len));
            len=0;
        }
        in.close();//关闭输入流

        return fileText.toString();
    }

    /**
     * 读取文件数据
     * @param fileFullAbsolutePath 完整的文件绝对路径形如：C:/demo/dir/demo.txt
     * @return
     */
    public static String readFile(String fileFullAbsolutePath){
        File targetFile=new File(fileFullAbsolutePath);
        if(!targetFile.exists()){
            logger.warning(logPrefix+"file '"+fileFullAbsolutePath+"' does not exists!");
            return null;
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(fileFullAbsolutePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(in == null){
            logger.warning(logPrefix+"BufferedReader 'in' is null!");
            return null;
        }
        String lineStr = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((lineStr = in.readLine()) != null) {
                stringBuilder.append(lineStr+'\n');//+ \n是为了还原原文本中存在的换行符
//                System.out.println(lineStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /**
     * 读取文件数据
     * @param filePath 形如：C:/demo/dir
     * @param fileName 形如：test.txt
     * @return
     *
     * String filePath = "C:\\Users\\千千寰宇\\Desktop";
     * String fileName = "js.js";
     * System.out.println(readFile(filePath,fileName));
     */
    public static String readFile(String filePath,String fileName){
        logPrefix="[FileUtil.readFile] ";
        String realPath = filePath+"/"+fileName;
        return readFile(realPath);
    }
}
