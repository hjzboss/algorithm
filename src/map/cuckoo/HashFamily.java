package map.cuckoo;

/**
 * 布谷鸟函数的散列函数集
 * @param <T>
 */
public interface HashFamily<T> {
    int hash(T x,int which);
    int getNumberOfFunctions();
    void generateNewFunctions();
}
