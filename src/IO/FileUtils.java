package IO;

import java.io.*;

/**
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-21 08:54
 **/
public class FileUtils {

    public static void main(String[] args) {
        //文件到文件
        try {
            InputStream is = new FileInputStream("test.txt");
            OutputStream os = new FileOutputStream("p-test.txt");
            copy(is, os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        byte[] datas = null;
        //文件到字节数组
        try {
            InputStream is = new FileInputStream("bg.jpg");
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            copy(is, os);
            datas = os.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //字节数组到文件
        try {
            InputStream is = new ByteArrayInputStream(datas);
            OutputStream os = new FileOutputStream("copy_bg.jpg");
            copy(is, os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void copy(InputStream is, OutputStream os) {
        try {
            byte[] flush = new byte[1024];//缓存容器1024
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
            close(is, os);
        }
    }

    /*public static void close(InputStream is, OutputStream os){
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
    }*/

    public static void close(Closeable... ios){
        for (Closeable io : ios) {
            try {
                if (null != io){
                    io.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
