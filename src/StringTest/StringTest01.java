package StringTest;

/**
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-17 20:41
 **/
public class StringTest01 {
    public static void main(String[] args) {
        String s1 = "core Java";
        String s2 = "Core Java";
        System.out.println(s1.charAt(3));//提取下标为3的字符
        System.out.println(s2.length());//字符串的长度
        System.out.println(s1.equals(s2));//比较两个字符串是否相等
        System.out.println(s1.equalsIgnoreCase(s2));//比较两个字符串（忽略大小写）
        System.out.println(s1.indexOf("Java"));//字符串s1中是否包含Java
        System.out.println(s1.indexOf("apple"));//字符串s1中是否包含apple
        String s = s1.replace(' ', '&');//将s1中的空格替换成&
        System.out.println("result is :" + s);

        int a = 2;
        int b = 3;
        System.out.println(b/a);

        Integer in1 = -128;
        Integer in2 = -128;
        System.out.println(in1 == in2);//true 因为123在缓存范围内
        System.out.println(in1.equals(in2));//true
        Integer in3 = 1234;
        Integer in4 = 1234;
        System.out.println(in3 == in4);//false 因为1234不在缓存范围内
        System.out.println(in3.equals(in4));//true
    }
}
