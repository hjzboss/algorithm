package test;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

/**
 * @author hjz
 * @version 1.0
 * @date 2021/4/17 22:16
 */
public class testn {
    private static int n;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        for (long i = 10000; i < 1000000; i++) {
            if (isRight(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isRight(long num) {
        String s = String.valueOf(num);
        String str = new StringBuilder(s).reverse().toString();
        if (s.equals(str)) {
            long sum = 0;
            while (num > 0) {
                sum = sum + num % 10;
                num /= 10;
            }
            return sum == n;
        }
        return false;
    }
}
