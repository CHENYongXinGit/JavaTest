package IO;

import java.io.*;

/**
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-19 19:53
 **/
public class IOTest09 {

    public static void main(String[] args){

        byte[] bytes = fileToByteArray("test.txt");
        System.out.println(bytes.length+"-->"+new String(bytes,0,bytes.length));
        byteArrayToFile(bytes, "p-test.txt");
    }

    /**
     * 1、图片读取到字节数组
     * 1)、图片到程序 FileInputStream
     * 2)、程序到字节数组 ByteArrayOutputStream
     */
    public static byte[] fileToByteArray(String filePath){
        byte[] dest = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            is = new FileInputStream(new File(filePath));
            baos = new ByteArrayOutputStream();
            byte[] flush = new byte[1024*10];//缓存容器1024
            int len = -1;//接收长度
            while ((len = is.read(flush)) != -1){
                baos.write(flush,0,len);
            }
            baos.flush();
            dest = baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != is){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dest;
    }

    /**
     * 2、字节数组写出到图片
     * 1)、字节数组到程序 ByteArrayInputStream
     * 2)、程序到文件 FileOutputStream
     */
    public static void byteArrayToFile(byte[] src, String filePath){
        ByteArrayInputStream bais = null;
        OutputStream os = null;
        try {
            bais = new ByteArrayInputStream(src);
            os = new FileOutputStream(new File(filePath));
            byte[] flush = new byte[5];//缓存容器1024
            int len = -1;//接收长度
            while ((len = bais.read(flush)) != -1){
                os.write(flush,0,len);
            }
            os.flush();
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
        }
    }
}
