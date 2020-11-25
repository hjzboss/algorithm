package leetcode.math;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解
 */
public class MaximumSubarray {
    /**
     *  分治法
     *
     *  执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 94.68%
     * 的用户
     * 内存消耗：
     * 38.2 MB
     * , 在所有 Java 提交中击败了
     * 91.41%
     * 的用户
     */
    public int maxSubArray(int[] nums) {
        if (nums.length < 2) return nums[0];
        return maxSum(nums, 0, nums.length - 1);
    }

    private int maxSum(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int mid = (right + left) / 2;
        //求出左右两侧的最大子序列和
        int leftSum = maxSum(nums, left, mid);
        int rightSum = maxSum(nums, mid + 1, right);

        //求出中间最大子序列和
        int maxLeftBorderSum = 0, LeftBorderSum = 0;
        for (int i = mid; i >= left; i--) {
            LeftBorderSum += nums[i];
            if (LeftBorderSum > maxLeftBorderSum) maxLeftBorderSum = LeftBorderSum;
        }

        int maxRightBorderSum = 0, RightBorderSum = 0;
        for (int i = mid + 1; i <= right; i++) {
            RightBorderSum += nums[i];
            if (RightBorderSum > maxRightBorderSum) maxRightBorderSum = RightBorderSum;
        }

        //返回最大的和
        return Math.max(Math.max(leftSum, rightSum), maxRightBorderSum + maxLeftBorderSum);
    }

}
