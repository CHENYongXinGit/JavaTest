package IO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-21 15:23
 **/
public class RandomTest01 {

    public static void main(String[] args) throws IOException {
        //分多少块
        File src = new File("D:/Program Files (x86)/IDEA/Test3/JavaTest/src/IO/Copy.java");
        //总长度
        long len = src.length();
        //每块大小
        int blockSize = 1024;
        //多少块
        int size = (int) Math.ceil(len*1.0/blockSize);


        //起初位置
        int beginPos = 0;
        //实际大小
        int actualSize = (int) (blockSize>len?len :blockSize);
        for (int i = 0; i < size; i++) {
            beginPos = i*blockSize;
            if (i==size-1){
                actualSize = (int) len;
            } else {
                actualSize = blockSize;
                len -= actualSize;
            }
            System.out.println(i+"-->"+beginPos+"-->"+actualSize);
            test03(i,beginPos,actualSize,src);
        }
    }

    /**
     * 指定第i块的起始位置和实际长度
     * @param i
     * @param beginPos
     * @param actualSize
     * @throws IOException
     */
    public static void test03(int i, int beginPos, int actualSize, File src) throws IOException {

        RandomAccessFile raf = new RandomAccessFile(src,"r");

        //随机读取
        raf.seek(beginPos);
        //操作（分段读取）
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len=raf.read(flush)) != -1){
            if (actualSize > len){
                System.out.println(new String(flush,0,len));
                actualSize -= len;
            } else {
                System.out.println(new String(flush,0,actualSize));
                break;
            }
        }
        raf.close();
    }

    /**
     * 分块思想:起始、实际大小
     * @throws IOException
     */
    public static void test02() throws IOException {

        RandomAccessFile raf = new RandomAccessFile(new File("D:/Program Files (x86)/IDEA/Test3/JavaTest/src/IO/Copy.java"),"r");
        //起初位置
        int beginPos = 2;
        //实际大小
        int actualSize = 1026;
        //随机读取
        raf.seek(beginPos);
        //操作（分段读取）
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len=raf.read(flush)) != -1){
            if (actualSize > len){
                System.out.println(new String(flush,0,len));
                actualSize -= len;
            } else {
                System.out.println(new String(flush,0,actualSize));
                break;
            }
        }
        raf.close();
    }

    /**
     * 指定读取位置，读取剩余的所有内容
     * @throws IOException
     */
    public static void test01() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("D:/Program Files (x86)/IDEA/Test3/JavaTest/src/IO/Copy.java"),"r");
        //随机读取(从第5个字节开始）
        raf.seek(5);
        //读取
        //操作（分段读取）
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len=raf.read(flush)) != -1){
            System.out.println(new String(flush,0,len));
        }
        raf.close();
    }
}
