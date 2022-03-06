package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hjz
 * @version 1.0
 * @date 2021/4/11 22:23
 */
public class Draft1 {
    private static int n;
    private static int[] ints;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        int p = cin.nextInt();
        ints = new int[100000];
        cin.nextLine();
        for (int i = 0; i < n; i++) {
            ints[i] = cin.nextInt();
        }

        Arrays.sort(ints, 0, n);

        int ans = 1;
        for (int i = 0; i < n; i++) {
            int j = binarySearch(i, (long) ints[i] * p);
            ans = Math.max(j - i, ans);
        }

        System.out.print(ans);
    }

    public static int binarySearch(int left, long max) {
        if (ints[n - 1] <= max) {
            return n;
        }

        int l = left + 1, r = n - 1;
        int mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (ints[mid] > max) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
