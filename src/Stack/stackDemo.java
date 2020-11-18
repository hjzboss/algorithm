package Stack;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeSet;

public class stackDemo {
    public static void main(String[] args) {
        stack<Integer> s = new stack<>(20);

        s.push(1);
        s.push(2);
        for (int a:s) {
            System.out.println(a);
        }//后进先出遍历
        System.out.println("-----------");
        s.foreach();//普通遍历

        TreeSet<String> strings = new TreeSet<>();
        strings.add("b");
        strings.add("a");
        strings.add("c");
        for(String st:strings){
            System.out.println(st);
        }
    }
}
