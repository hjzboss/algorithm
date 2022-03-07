package sort;

public class Selection implements Sort {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int min;
        for(int i = 0;i<N;i++){
            min = i;
            for(int j = i+1;j<N;j++){
                if(SortUtils.less(a[j],a[min])) min = j;
            }
            SortUtils.exch(a,i,min);
        }
    }
}
