package Search;
//双调查找，山峰数组求峰值
public class bitonicSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,5,6,4};
        System.out.println(bitonicSearch(arr));
    }

    public static int bitonicSearch(int[] a){
        if(a.length == 0 || a == null) return -1;
        if(a.length == 2) return a[0]>a[1]?0:1;
        int left = 0;
        int right = a.length-1;
        int mid = -1;
//        while(left < right){//模板一
//            mid = (right+left)/2;
//            if(a[mid]>a[mid+1]) right = mid;
//            else left = mid+1;
//        }
//        return right;
        while(left <= right){//模板二
            mid = (right+left)/2;
            if(a[mid]>a[mid-1]&&a[mid]>a[mid+1]) return mid;
            else if(a[mid]<a[mid+1]) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
}
