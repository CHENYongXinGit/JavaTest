package IO.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 拷贝
 *
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-21 20:22
 **/
public class CIOTest04 {
    public static void main(String[] args) throws IOException {
        //复制文件
        //FileUtils.copyFile(new File("bg.jpg"),new File("copy-bg.jpg"));

        //复制文件到目录
        //FileUtils.copyFileToDirectory(new File("bg.jpg"),new File("images"));

        //复制目录到目录（把目录1的目录和内容拷贝到目录2）
        //FileUtils.copyDirectoryToDirectory(new File("lib"),new File("lib2"));

        //复制目录（把目录1内容拷贝到目录2）
        //FileUtils.copyDirectory(new File("lib"),new File("lib2"));

        //拷贝URL内容
        //FileUtils.copyURLToFile(new URL("http://www.baidu.com"),new File("baidu.html"));

        //
        String s = IOUtils.toString(new URL("http://www.baidu.com"), "UTF-8");
        System.out.println(s);

    }
}
