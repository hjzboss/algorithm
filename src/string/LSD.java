package string;

import org.jetbrains.annotations.NotNull;

//低位优先的字符串排序
public class LSD {
    /*
     * 通过前w个字符将a[]排序
     */
    public static void sort(@NotNull String[] a, int w) {
        int N = a.length;
        int R = 256;
        String aux[] = new String[N];

        for (int i = w - 1; i >= 0; i--) {
            int[] count = new int[R + 1];
            for (int j = 0; j < N; j++) {//计算出现频率
                count[a[j].charAt(i) + 1]++;
            }
            for (int r = 0; r < R; r++) {//将频率转换为索引
                count[r + 1] += count[r];
            }
            for (int k = 0; k < N; k++) {//将元素分类
                aux[count[a[k].charAt(i)]++] = a[k];
            }
            for (int j = 0; j < N; j++) {
                a[j] = aux[j];
            }
        }
    }

    public static void main(String[] args) {
        String[] str = {"123","213","132","231","321"};
        sort(str,3);
        for(String s:str){
            System.out.println(s);
        }
    }
}
