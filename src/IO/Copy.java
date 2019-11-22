package IO;

import java.io.*;

/**
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-19 19:53
 **/
public class Copy {

    public static void main(String[] args){
//        copy("src/images/bg.jpg", "copy_bg.jpg");
        copy2("src/images/bg.jpg", "copy.jpg");
    }

    private static void copy(String srcPath, String destPath) {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(new File(srcPath));
            os = new FileOutputStream(new File(destPath));
            byte[] flush = new byte[3];//缓存容器1024
            int len = -1;//接收长度
            while ((len = is.read(flush)) != -1){
                os.write(flush,0,len);
                os.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != os){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null != is){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void copy2(String srcPath, String destPath) {
        try(InputStream is = new FileInputStream(new File(srcPath));
            OutputStream os = new FileOutputStream(new File(destPath));) {
            byte[] flush = new byte[3];//缓存容器1024
            int len = -1;//接收长度
            while ((len = is.read(flush)) != -1){
                os.write(flush,0,len);
                os.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
