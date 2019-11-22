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
public class RandomTest02 {

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
            split(i,beginPos,actualSize,src);
        }
    }

    /**
     * 指定第i块的起始位置和实际长度
     * @param i
     * @param beginPos
     * @param actualSize
     * @param src
     * @throws IOException
     */
    public static void split(int i, int beginPos, int actualSize, File src) throws IOException {

        File file = new File("dest/");
        if (!file.exists()){
            file.mkdirs();
        }
        RandomAccessFile raf1 = new RandomAccessFile(src,"r");
        RandomAccessFile raf2 = new RandomAccessFile(new File("dest/"+i+"Copy.java"),"rw");


        //随机读取
        raf1.seek(beginPos);
        //操作（分段读取）
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len=raf1.read(flush)) != -1){
            if (actualSize > len){
                System.out.println(new String(flush,0,len));
                raf2.write(flush,0,len);
                actualSize -= len;
            } else {
                System.out.println(new String(flush,0,actualSize));
                raf2.write(flush,0,actualSize);
                break;
            }
        }
        raf2.close();
        raf1.close();
    }
}
