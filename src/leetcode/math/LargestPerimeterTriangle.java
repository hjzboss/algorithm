package leetcode.math;

import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * <p>
 * 如果不能形成任何面积不为零的三角形，返回 0。
 * <p>
 * 示例 1：
 * 输入：[2,1,2]
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：[1,2,1]
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：[3,2,3,4]
 * 输出：10
 * <p>
 * 示例 4：
 * 输入：[3,6,2,3]
 * 输出：8
 * <p>
 * 提示：
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 */
public class LargestPerimeterTriangle {
    /**
     * 执行结果：
     * 通过
     * <p>
     * 显示详情
     * 执行用时：8 ms, 在所有 Java 提交中击败了97.44%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了91.34%的用户
     */
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int large = A.length - 1;
        while (large >= 2) {
            if (A[large - 2] + A[large - 1] > A[large]) {
                return A[large - 2] + A[large - 1] + A[large];
            } else {
                large--;
            }
        }
        return 0;
    }
}
