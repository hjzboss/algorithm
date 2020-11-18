package sort;

public class QuickSort implements Sort {
    @Override
    public void sort(Comparable[] a) {
        if(a == null) return;
        sort(a,0,a.length-1);
    }

    /*
    * 快速排序改良版
    * */
    public void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo+3) {Insertion.sort(a,lo,hi);return;}//元素较少时切换到插入排序
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private int partition(Comparable[] a,int lo,int hi){//切分算法
        Comparable v = select(a,lo,hi);
        int i = lo,j = hi - 1;
        while(true){
            while(Sort.less(a[++i],v)) {}
            while(Sort.less(v,a[--j])) {}
            if(i < j) Sort.exch(a,i,j);
            else break;
        }
        Sort.exch(a,i,hi-1);
        return i;
    }

    /*
        取数组头、中、尾三个元素，将三个元素排好序后将中位数放在数组的倒数第二个位置充当哨兵
    * */
    private Comparable select(Comparable[] a,int lo,int hi){
        int mid = (hi+lo)/2;
        if(Sort.less(a[mid],a[lo])){
            Sort.exch(a,mid,lo);
        }
        if(Sort.less(a[hi],a[lo])){
            Sort.exch(a,hi,lo);
        }
        if(Sort.less(a[hi],a[mid])){
            Sort.exch(a,hi,mid);
        }
        Sort.exch(a,mid,hi-1);//将其放置在倒数第二个位置充当哨兵
        return a[hi-1];
    }

    /*
    * 快速排序标准算法
    * */
    public static int partitonNormal(Comparable[] a,int lo,int hi){
        Comparable t = a[lo];
        int i = lo,j = hi+1;
        while(true){
            while(Sort.less(a[++i],t)) {if(i>=hi) break; }
            while(Sort.less(t,a[--j])) {if(j<=lo) break;}
            if(i>=j)break;
            Comparable temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        Comparable temp = a[lo];
        a[lo] = a[j];
        a[j] = temp;
        return j;
    }

    public static void qsNormal(Comparable[] a,int lo,int hi){
        if(hi<=lo) return;
        int j = partitonNormal(a,lo,hi);
        qsNormal(a,lo,j-1);
        qsNormal(a,j+1,hi);
    }

    public static void main(String[] args) {
        Integer a[] = new Integer[]{6,5,4,3,2,1};
        QuickSort.qsNormal(a,0,a.length-1);
        for(int n:a){
            System.out.println(n);
        }
    }
}
