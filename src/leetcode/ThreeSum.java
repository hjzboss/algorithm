package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    /**
     * 思路：先对数组进行排序，再进行遍历，查找
     *
     * 执行结果：通过
     * 显示详情
     * 执行用时：22 ms, 在所有 Java 提交中击败了93.96%的用户
     * 内存消耗：42.2 MB, 在所有 Java 提交中击败了90.52%的用户
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sum = new ArrayList<List<Integer>>();
        if(nums.length < 3 || nums == null) return sum;

        int N = nums.length,temp,left,right;
        //排序
        Arrays.sort(nums);

        for(int i = 0;i < N-2;i++){
            //如果第一个数就大于零，和就不可能为0了，排序后后面的数都比它大
            if(nums[i] > 0) break;
            //如果和前面一个相同，就跳过。防止重复的三元组
            if(i > 0 && nums[i] == nums[i-1]) continue;
            temp = -nums[i];
            left = i + 1;
            right = N - 1;
            while(left < right){
                if(nums[left] + nums[right] == temp){
                    sum.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    //判断第二个数是否和之前遍历过的相同，排除重复
                    while(left < right && nums[left - 1] == nums[left]) left++;
                    //判断第三个数是否和之前遍历过的相同
                    while(left < right && nums[right] == nums[right + 1]) right--;
                }else if(nums[left] + nums[right] < temp) {
                    //如果和小于0
                    left++;
                }else {
                    //如果和大于0
                    right--;
                }
            }
        }


        return sum;
    }
}
