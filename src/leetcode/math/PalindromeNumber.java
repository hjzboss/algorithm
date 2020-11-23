package leetcode.math;

/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class PalindromeNumber {
    /**
     * 我的解法：双指针，将输入的数转换为字符数组，两头进行比较
     * <p>
     * 执行结果：
     * 通过
     * <p>
     * 显示详情
     * <p>
     * 执行用时：
     * 10 ms, 在所有 Java 提交中击败了79.55%的用户
     * 内存消耗：
     * 37.7 MB, 在所有 Java 提交中击败了91.33%的用户
     */
    public boolean isPalindrome1(int x) {
        if (x < 0) return false;

        char[] num = String.valueOf(x).toCharArray();
        int i = 0, j = num.length - 1;

        while (i < j) {
            if (num[i] != num[j]) return false;
            i++;
            j--;
        }

        return true;
    }

    /**
     * 简单粗暴解法：使用StringBuilder的reverse方法来反转字符串，不过很慢很占空间
     */
    public boolean isPalindrome2(int x) {
        String n = new StringBuilder("" + x).reverse().toString();
        return n.equals("" + x);
    }

    /**
     * 巧妙解法：将回文数的后半段反转与前半段进行比较
     */
    public boolean isPalindrome3(int x) {
        //末尾为 0 就可以直接返回 false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        //后半段
        int revertedNumber = 0;
        //每次循环将x最后一位加到后半段，前半段减少一位
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        //如果出现前半段的数小于后半段的数，说明x的位数为奇数，中间一位最后会加在后半段上，如121中的2
        // 需要将后半段除以10再与前半段进行比较
        return x == revertedNumber || x == revertedNumber / 10;
    }

    /**
     * 数学解法：首尾比较
     */
    public boolean isPalindrome(int x) {
        //边界判断
        if (x < 0) return false;
        int div = 1;
        //关键：找出最大的除数
        while (x / div >= 10) div *= 10;

        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            //将x截去首尾两位
            x = (x % div) / 10;
            //除数要缩小100倍，因为被除数减少了两位
            div /= 100;
        }

        return true;
    }
}
