package test;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main2 {
    public static void main(String[] args) {
        //用一个数组保存节点下一个节点的下标
        int[] tab = new int[202];
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        String target = cin.next();//指定节点
        //正则表达式
        String reg = "[^0-9]";
        Pattern p = Pattern.compile(reg);

        //分离"[node1->node2][node2->node3][node3->node4]"字符串并提取其中数字的操作
        String[] split = str.substring(1, str.length() - 1).split("]\\[");
        for (String s : split) {
            String[] arr = s.split("->");
            String s1 = p.matcher(arr[0]).replaceAll("").trim();
            Integer a0 = Integer.valueOf(s1) + 1;
            String s2 = p.matcher(arr[1]).replaceAll("").trim();
            Integer a1 = Integer.valueOf(s2) + 1;
            tab[a0] = a1;
        }

        String trim = p.matcher(target).replaceAll("").trim();
        Integer a1 = Integer.valueOf(trim) + 1;
        int temp = a1;
        int last = 0,pre = 0;
        //求指定节点到最后节点的数目
        for(int i = temp;tab[temp] != 0;temp = tab[temp]){
            last++;
        }

        int flag = a1;
        //求前面的数目
        for(int j = 1;j < tab.length;j++){
            int i = 1;
            for(;i < tab.length;i++){
                if(tab[i] == flag) {
                    flag = i;
                    pre++;
                    break;
                }
            }
            if(i == tab.length) break;
        }

        System.out.println(pre + " " + last);
    }
}
