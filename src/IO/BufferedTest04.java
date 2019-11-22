package IO;

import java.io.*;

/**
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-19 19:53
 **/
public class BufferedTest04 {

    public static void main(String[] args){

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(new File("test.txt")));
            String msg = "IO is so easy 陈永鑫";
            writer.append(msg);
            writer.newLine();
            writer.append("kkk");
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
