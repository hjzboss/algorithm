package sum;

import java.util.Arrays;

public class sum {
    public static void main(String[] args) {
        int []a = {1,2,3,-1,-2,-3};
        System.out.println(count(a));//3
        System.out.println(countfast(a));//3
    }

    public static int count(int[] a){//统计和为0的元组的数量：暴力解法  时间复杂度为N^2
        int N = a.length;
        int cnt = 0;//计数器
        for(int i = 0;i<N;i++){
            for(int j = i+1;j<N;j++){
                if(a[i] == -a[j]) cnt++;
            }
        }
        return cnt;
    }

    public static int countfast(int[] a){//快速解法：二分查找  时间复杂度为NlogN
        int N = a.length;
        int cnt = 0;
        Arrays.sort(a);//二分查找之前进行排序
        for(int i = 0;i<N;i++){
            if(Arrays.binarySearch(a,-a[i])>i){ cnt++; }
        }
        return cnt;
    }
}
