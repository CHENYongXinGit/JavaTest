package IO;

import java.io.*;

/**
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-19 19:53
 **/
public class IOTest02 {

    public static void main(String[] args){

        InputStream is = null;
        try {
            is = new FileInputStream(new File("test.txt"));
            byte[] flush = new byte[3];//缓存容器1024
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
}
