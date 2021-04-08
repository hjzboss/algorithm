package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hjz
 * @version 1.0
 * @date 2021/4/5 22:50
 */
public class Fortune {
    public static void main(String[] args) {
        int m, n, num = 0, tmp = Integer.MAX_VALUE;
        Scanner cin = new Scanner(System.in);
        m = cin.nextInt();
        n = cin.nextInt();
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(-1);
        for (int i = 1; i < n; i++) {
            integers.add(i);
        }

        for (int i = 1; i < integers.size(); i++) {
            tmp = integers.get(i);
            if (tmp == 1) {
                continue;
            }
            for (int j = i; j < integers.size(); j++) {
                if (tmp % j == 0) {
                    integers.remove(j);
                }
            }
        }

        for(int i = 1;i < integers.size();i++) {
            tmp = integers.get(i);
            if(tmp > m) num++;
        }

        System.out.println(num);

/*        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        int[] a = new int[n+1];

        for(int i=1;i<=n;i++)
            a[i] = i;
        for(int i=1;i<=n;i++)
            if(i%2==0)
                a[i] = Integer.MAX_VALUE;
        Arrays.sort(a);
        int t = n;
        for(int i=2;i<=t;i++) {
            int k = a[i];
            if(k==Integer.MAX_VALUE)
                break;
            for(int j=k;j<=t;j+=k)
                a[j] = Integer.MAX_VALUE;
            Arrays.sort(a,1,t);
            for(int j=1;j<=t;j++)
                if(a[j]==Integer.MAX_VALUE) {
                    t = j;
                    break;
                }
        }

        int ans = 0;
        for(int i=1;i<=n;i++) {
            if(a[i]>m && a[i]<n)
                ans++;
        }
        System.out.println(ans);*/
    }
}
