package sort;

public interface Sort {
    void sort(Comparable[] a);

    static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    static boolean lesse(Comparable v,Comparable w){
        return ((v.compareTo(w)<0)||(v.compareTo(w)==0));
    }

    static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static void show(Comparable[] a){
        for(int i = 0;i<a.length;i++){
            System.out.println(a[i]+" ");
            System.out.println();
        }
    }

    static boolean isorted(Comparable[] a){
        for(int i = 1;i<a.length;i++){
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }
}
