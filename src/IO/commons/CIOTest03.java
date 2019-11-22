package IO.commons;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 写出内容
 *
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-21 20:22
 **/
public class CIOTest03 {
    public static void main(String[] args) throws IOException {
        //写出文件
        FileUtils.write(new File("happy.cyx"),"学习是一件伟大的事业\r\n","UTF-8");
        FileUtils.writeStringToFile(new File("happy.cyx"),"学习是一件辛苦的事业\r\n","UTF-8",true);
        FileUtils.writeByteArrayToFile(new File("happy.cyx"),"学习是一件幸福的事业\r\n".getBytes("UTF-8"),true);

        //写出列表
        List<String> datas = new ArrayList<>();
        datas.add("＄");
        datas.add("健康档案");
        datas.add("撒刁");
        FileUtils.writeLines(new File("happy.cyx"),datas,"---",true);
    }
}
