package IO;

import java.io.*;

/**
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-19 19:53
 **/
public class IOTest05 {

    public static void main(String[] args){

        Reader reader = null;
        try {
            reader = new FileReader(new File("test.txt"));
            char[] flush = new char[1024];//缓存容器1024
            int len = -1;//接收长度
            while ((len = reader.read(flush)) != -1){
                String str = new String(flush,0,len);
                System.out.print(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != reader){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
