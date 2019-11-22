package IO;

import java.io.*;

/**
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-19 19:53
 **/
public class BufferedTest03 {

    public static void main(String[] args){

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File("test.txt")));
            String line = null;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != reader){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
