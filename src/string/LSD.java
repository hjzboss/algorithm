package string;

import org.jetbrains.annotations.NotNull;

//低位优先的字符串排序，计数基数排序
public class LSD {
    /*
     * 通过前w个字符将a[]排序
     */
    public static void sort(@NotNull String[] a, int w) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        String[] in = a;
        String[] out = aux;

        for (int i = w - 1; i >= 0; i--) {
            int[] count = new int[R + 1];
            for (int j = 0; j < N; j++) {//计算出现频率
                count[a[j].charAt(i) + 1]++;
            }
            for (int r = 0; r < R; r++) {//将频率转换为索引
                count[r + 1] += count[r];
            }
            for (int k = 0; k < N; k++) {//将元素分类
                out[count[a[k].charAt(i)]++] = in[k];
            }

            String[] tmp = in;
            in = out;
            out = tmp;
        }

        //如果趟数是偶数次，out引用的是a，排序就结束了；否则out引用的是aux，需要把aux复制回a
        if (w % 2 == 1) {
            for (int i = 0; i < N; i++) {
                out[i] = in[i];
            }
        }
    }

    public static void main(String[] args) {
        String[] str = {"123", "213", "132", "231", "321", "000"};
        sort(str, 3);
        for (String s : str) {
            System.out.println(s);
        }
    }
}
