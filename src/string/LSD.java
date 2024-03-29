package string;


/**
 * 低位优先的字符串排序，计数基数排序
 */
public class LSD {
    /**
     * 通过前w个字符将a[]排序
     *
     * @param a 待排序数组
     * @param w 根据前w个字符排序
     */
    public static void sort(String[] a, int w) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        for (int i = w - 1; i >= 0; i--) {
            int[] count = new int[R + 1];
            for (String s : a) {//计算出现频率
                count[s.charAt(i) + 1]++;
            }
            for (int r = 0; r < R; r++) {//将频率转换为索引
                count[r + 1] += count[r];
            }
            for (String s : a) {//将元素分类
                aux[count[s.charAt(i)]++] = s;
            }
            System.arraycopy(aux, 0, a, 0, N);
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
