package IO;

import java.io.File;

/**
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-19 19:10
 **/
public class DirDemo01 {

    public static void main(String[] args) {
        File src = new File("D:/Program Files (x86)/IDEA/Test3/JavaTest");
        //printName(src,0);
        count(src);
        System.out.println(len);
    }

    //打印文件层次
    public static void printName(File src, int deep){
        for (int i = 0; i < deep; i++) {
            System.out.print("-");
        }
        System.out.println(src.getName());
        if (src == null || !src.exists()) {
            return;
        } else if (src.isDirectory()){
            for (File s : src.listFiles()){
                printName(s,deep+1);
            }
        }
    }

    //文件大小
    private static long len = 0;
    public static void count(File src){

        if (src != null && src.exists()) {
            if (src.isFile()){
                len += src.length();
            } else {
                for (File s : src.listFiles()){
                    count(s);
                }
            }
        }
    }
}
