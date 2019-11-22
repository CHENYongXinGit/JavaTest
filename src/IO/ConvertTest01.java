package IO;

import java.io.*;

/**
 *
 * 转换流
 * 1、以字符流的形式操作字节流（纯文本）
 *
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-21 10:57
 **/
public class ConvertTest01 {
    public static void main(String[] args) {
        //操作System.in和System.out
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));){

            //
            String msg = "";
            while (!msg.equals("exit")){
                msg = reader.readLine();//循环读取
                writer.write(msg);//循环写出
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
