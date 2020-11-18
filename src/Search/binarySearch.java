package Search;

import java.util.Scanner;

public class binarySearch {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入数组的长度：");
        int i1 = s.nextInt();
        int[] arr = new int[i1];
        for(int i = 0;i<arr.length;i++){
            System.out.println("请输入数组元素：");
            arr[i] = s.nextInt();
        }
        System.out.println("请输入要查找的元素：");
        int value = s.nextInt();
        int binary = binary(arr, value);
        System.out.println("元素的下标为："+binary);
    }
    public static int binary(int a[],int key){
        int low = 0;
        int high = a.length-1;
        int mid;
        while(low <= high){
            mid = low + (high-low)/2;
            if(key < a[mid]) high = mid - 1;
            else if(key > a[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }
}
