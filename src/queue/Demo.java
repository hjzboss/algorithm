package queue;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        queue<String> queue = new queue<String>(10);
        Scanner in = new Scanner(System.in);
        while (!in.hasNext("#")) {
            String item = in.next();
            if (!item.equals("-")) queue.enqueue(item);
            else if (!queue.isEmpty()) System.out.println(queue.dequeue() + " ");//遇见减号则出队
        }
        System.out.println("(" + queue.size() + " left on queue)");//队列中剩余元素数目
        for(String a:queue){
            System.out.print(a+" ");//打印剩余的元素
        }

    }
}
