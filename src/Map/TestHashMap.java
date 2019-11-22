package Map;

import java.util.HashMap;

/**
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-19 11:05
 **/
public class TestHashMap<K,V> {
    Node<K,V>[] table;  //位桶数组。bucket array
    int size;

    public TestHashMap() {
        table = new Node[16]; //长度一般定义为2的整数幂
    }

    public V get(K key) {

        int hash = myHash(key.hashCode(), table.length);
        V value = null;

        if (table[hash]!=null){
            Node<K,V> temp = table[hash];
            while (temp!=null){
                if (temp.key.equals(key)){
                    value = temp.value;
                    break;
                } else {
                    temp = temp.next;
                }
            }
        }

        return value;
    }

    public void put(K key, V value){
        Node<K,V> newNode = new Node<>();
        newNode.hash = myHash(key.hashCode(),table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        Node<K,V> temp = table[newNode.hash];
        Node<K,V> iterLast = null;
        boolean keyRepeat = false;
        if (temp==null){
            table[newNode.hash] = newNode;
            size++;
        } else {
            while (temp != null){
                //判断key
                if (temp.key.equals(key)){
                    //如果重复，则覆盖
                    keyRepeat = true;
                    temp.value = value;
                    break;
                } else {
                    //key不重复
                    iterLast = temp;
                    temp = temp.next;
                }
            }

            //没有发生key重复的情况，则添加到链表最后
            if (!keyRepeat) {
                iterLast.next = newNode;
                size++;
            }
        }
    }

    public int myHash(int v, int length){
        return v&(length-1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');

        for (int i = 0; i < table.length; i++) {
            Node temp = table[i];
            while (temp!=null){
                sb.append(temp.key+":"+temp.value+"，");
                temp = temp.next;
            }
        }
        sb.setCharAt(sb.length()-1,'}');
        return sb.toString();
    }
}
