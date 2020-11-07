package sort;

public class Merge implements Sort {
    public void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }

    private static void sort(Comparable[] a, Comparable[] aux,int lo, int hi) {//递归实现
        if(hi<=lo) return;//数组中没有元素就返回，递归终点
        int mid = lo + (hi - lo)/2;
        sort(a,aux,lo,mid);//对左边排序
        sort(a,aux,mid+1,hi);//对右边排序
        if(a[mid].compareTo(a[mid+1])<0) return;
        merge(a,aux,lo,mid,hi);//归并
    }

    private static void merge(Comparable[] a,Comparable[] aux,int lo,int mid,int hi){//归并（假设数组两边已排好序）
        int i = lo,j = mid + 1;
        for(int k = lo;k <= hi;k++){
            aux[k] = a[k];
        }
        for(int k = lo;k <= hi;k++){
            if(i>mid) a[k] = aux[j++];//左半边用尽
            else if(j>hi) a[k] = aux[i++];//右半边用尽
            else if(aux[j].compareTo(aux[i])<0) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static void sort2(Comparable[] a){//归并排序非递归实现
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for(int sz = 1;sz<N;sz = sz*2){
            for(int lo = 0;lo<N-sz;lo+=sz+sz){
                if(a[lo+sz-1].compareTo(a[lo+sz])>0)
                merge(a,aux,lo,lo+sz-1,Math.min(lo+2*sz-1,N-1));
            }
        }
    }
}
