package Search;
//查找局部最小元素
public class LocalMininum {
    public static void main(String[] args) {
        int[] arr = new int[]{-4,-3,-2,-1,4,3,1,2};
        System.out.println(mininum(arr));
    }
    public static int mininum(int[] a){
        if(a.length == 0||a == null) return -1;
        if(a.length == 1) return 0;
        if(a[0]<a[1]) return 0;
        if(a[a.length-1]<a[a.length-2]) return a.length-1;

        int left = 1;
        int right = a.length-2;
        int mid;
        while (left <= right){
            mid = (left+right)/2;
            if(a[mid]<a[mid+1]&&a[mid]<a[mid-1]) return mid;
            else if(a[mid]>a[mid-1]) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
