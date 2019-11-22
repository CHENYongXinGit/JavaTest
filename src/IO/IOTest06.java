package IO;

import java.io.*;

/**
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-19 19:53
 **/
public class IOTest06 {

    public static void main(String[] args){

        Writer writer = null;
        try {
            writer = new FileWriter(new File("test.txt"),true);//append:true在后面追加，默认false
            //写法一
//            String msg = "\r\nIO is so easy 陈永鑫";//\r\n换行
//            char[] datas = msg.toCharArray();
//            writer.write(datas,0,datas.length);
//            writer.flush();
            //写法二
//            String msg = "\r\nIO is so easy 陈永鑫";//\r\n换行
//            writer.write(msg);
//            writer.flush();
            //写法三
            String msg = "\r\nIO is so easy 陈永鑫";//\r\n换行
            writer.append(msg).append("kkk");
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != writer){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
