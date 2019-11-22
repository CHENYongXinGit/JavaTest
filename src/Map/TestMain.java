package Map;

import java.util.HashMap;

/**
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-19 14:52
 **/
public class TestMain {
    public static void main(String[] args) {
        TestHashMap<Integer, String> map = new TestHashMap<>();
        map.put(65,"aaa");
        map.put(53,"aa");
        map.put(69,"bb");
        map.put(85,"cc");
        System.out.println(map);
    }
}
