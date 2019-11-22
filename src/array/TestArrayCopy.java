package array;

import java.util.Arrays;

/**
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-18 12:55
 **/
public class TestArrayCopy {
    public static void main(String args[]) {
        String[] s = {"阿里","尚学堂","京东","搜狐","网易"};
        String[] sBak = new String[6];
        System.arraycopy(s,0,sBak,1,s.length);
        for (int i = 0; i < sBak.length; i++) {
            System.out.print(sBak[i]+ "\t");
        }

        Man[] msMans = { new Man(3, "a"), new Man(60, "b"), new Man(2, "c") };
        Arrays.sort(msMans);
        System.out.println(Arrays.toString(msMans));

        int[] a = {1,2,323,23,543,12,59};
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);   //使用二分法查找，必须先对数组进行排序;
        System.out.println(Arrays.toString(a));
        //返回排序后新的索引位置,若未找到返回负数。
        System.out.println("该元素的索引："+Arrays.binarySearch(a, 12));

        int[] b= {1,2,323,23,543,12,59};
        System.out.println(Arrays.toString(b));
        Arrays.fill(b, 2, 4, 100);  //将2到4索引的元素替换为100;
        System.out.println(Arrays.toString(b));
    }
}

class Man implements Comparable {
    int age;
    int id;
    String name;

    public Man(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public int compareTo(Object o) {
        Man man = (Man) o;
        if (this.age < man.age) {
            return -1;
        }
        if (this.age > man.age) {
            return 1;
        }
        return 0;
    }
}

