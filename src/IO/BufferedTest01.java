package IO;

import java.io.*;

/**
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-19 19:53
 **/
public class BufferedTest01 {

    public static void main(String[] args){

//        test1();
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(new File("test.txt")));
            byte[] flush = new byte[1024];//缓存容器1024
            int len = -1;//接收长度
            while ((len = is.read(flush)) != -1){
                String str = new String(flush,0,len);
                System.out.print(str);
            }
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
    }

    private static void test1() {
        InputStream is = null;
        BufferedInputStream bis = null;
        try {
            is = new FileInputStream(new File("test.txt"));
            bis = new BufferedInputStream(is);
            byte[] flush = new byte[1024];//缓存容器1024
            int len = -1;//接收长度
            while ((len = bis.read(flush)) != -1){
                String str = new String(flush,0,len);
                System.out.print(str);
            }
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
            try {
                if (null != bis){
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
