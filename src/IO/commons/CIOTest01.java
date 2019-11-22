package IO.commons;

import org.apache.commons.io.DirectoryWalker;
import org.apache.commons.io.EndianUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.*;

import java.io.File;
import java.util.Collection;

/**
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-21 19:55
 **/
public class CIOTest01 {
    public static void main(String[] args) {
        //文件大小
        long len = FileUtils.sizeOf(new File("D:/Program Files (x86)/IDEA/Test3/JavaTest/test.txt"));
        System.out.println("文件大小:"+len);
        //文件目录大小
        len = FileUtils.sizeOf(new File("D:/Program Files (x86)/IDEA/Test3/JavaTest"));
        System.out.println("文件目录大小:"+len);

        //列出子孙级 1,目录2,文件过滤器（非空、后缀）3，层次
        //Collection<File> files1 = FileUtils.listFiles(new File("D:/Program Files (x86)/IDEA/Test3/JavaTest"), EmptyFileFilter.NOT_EMPTY, null);
        //Collection<File> files2 = FileUtils.listFiles(new File("D:/Program Files (x86)/IDEA/Test3/JavaTest"), EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
        Collection<File> files3 = FileUtils.listFiles(
                new File("D:/Program Files (x86)/IDEA/Test3/JavaTest"), new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);
        Collection<File> files4 = FileUtils.listFiles(
                new File("D:/Program Files (x86)/IDEA/Test3/JavaTest"),
                FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class"),EmptyFileFilter.EMPTY),
                DirectoryFileFilter.INSTANCE);
        Collection<File> files5 = FileUtils.listFiles(
                new File("D:/Program Files (x86)/IDEA/Test3/JavaTest"),
                FileFilterUtils.and(new SuffixFileFilter("java"),EmptyFileFilter.NOT_EMPTY),
                DirectoryFileFilter.INSTANCE);
        for (File file : files5) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
