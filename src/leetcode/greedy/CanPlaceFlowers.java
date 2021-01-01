package leetcode.greedy;

/**
 * 605. 种花问题
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。
 * 可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。
 * 能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * <p>
 * 示例 1:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 * <p>
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 */
public class CanPlaceFlowers {

    /**
     * 我的解法：遍历数组，查找相邻为0的元素
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0) {
                n--;
            }
            return n <= 0;
        }

        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 1) continue;
            if (i == 0 && flowerbed.length > 1) {
                if (flowerbed[1] == 0) {
                    flowerbed[0] = 1;
                    n--;
                }
            } else if (i == flowerbed.length - 1 && flowerbed.length > 1) {
                if (flowerbed[i - 1] == 0) n--;
            } else {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }

        return n == 0;
    }

    /**
     * 解法二：一次跳两个，因为不会有相邻的花
     * 作者：HERODing
     */
    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        // 每次跳两格
        for (int i = 0; i < flowerbed.length; i += 2) {
            // 如果当前为空地
            if (flowerbed[i] == 0) {
                // 如果是最后一格或者下一格为空
                if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                    n--;
                } else {
                    i++;
                }
            }
        }
        return n <= 0;
    }
}
