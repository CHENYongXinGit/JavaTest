package IO;

import java.io.*;
import java.net.URL;

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
public class ConvertTest02 {
    public static void main(String[] args) {
        //操作网络流 下载百度的源代码
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"),"UTF-8"))){

            String line;
            while ((line=reader.readLine()) != null){
                writer.write(line);
                writer.newLine();
            }
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void test1() {
        try (InputStreamReader reader = new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8")){

            int temp;
            while ((temp=reader.read()) != -1){
                System.out.print((char)temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void test2() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8"))){

            String line;
            while ((line=reader.readLine()) != null){
                System.out.print(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
