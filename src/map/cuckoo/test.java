package map.cuckoo;

/**
 * 布谷鸟测试类
 */
public class test {
    private static final HashFamily<String> hashFamily = new HashFamily<>() {
        //根据which选取不同的散列函数
        @Override
        public int hash(String x, int which) {
            int hashVal = 0;
            switch (which) {
                case 0: {
                    for (int i = 0; i < x.length(); i++) {
                        hashVal += x.charAt(i);
                    }
                    break;
                }
                case 1:
                    for (int i = 0; i < x.length(); i++) {
                        hashVal = 37 * hashVal + x.charAt(i);
                    }
                    break;
            }
            return hashVal;
        }

        //返回散列函数集合的个数
        @Override
        public int getNumberOfFunctions() {
            return 2;
        }

        @Override
        public void generateNewFunctions() {

        }
    };

    public static void main(String[] args) {
        //定义布谷鸟散列
        CuckooHashTable<String> cuckooHashTable = new CuckooHashTable<>(hashFamily, 5);
        String[] strs = {"abc", "nice", "ok", "123"};
        //插入
        for (int i = 0; i < strs.length; i++) {
            cuckooHashTable.insert(strs[i]);
        }
        //打印表
        cuckooHashTable.printArray();

        cuckooHashTable.remove("ok");
        cuckooHashTable.printArray();
    }
}
