package IO.commons;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * 读取内容
 *
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-21 20:22
 **/
public class CIOTest02 {
    public static void main(String[] args) throws IOException {
        //读取文件
        String msg = FileUtils.readFileToString(new File("D:/Program Files (x86)/IDEA/Test3/JavaTest/test.txt"),"UTF-8");
        System.out.println(msg);
        byte[] datas = FileUtils.readFileToByteArray(new File("test.txt"));
        System.out.println(datas.length);

        //逐行读取
        List<String> msgs = FileUtils.readLines(new File("test.txt"),"UTF-8");
        for (String s : msgs) {
            System.out.println("==>"+s);
        }
    }
}
