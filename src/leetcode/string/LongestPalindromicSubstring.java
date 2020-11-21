package leetcode.string;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindromicSubstring {
    //我的解法：动态规划，用一个二维数组记录子串是否为回文串，
    // 行下标代表子串起始位置，列下标代表终止位置
    // 如果数组对应元素为true，则说明该子串是回文串
    //状态转移方程：P(i,j)=P(i+1,j−1)∧(s[i] == s[j])
    public class Solution {
        public String longestPalindrome(String s) {
            //如果长度小于2，
            int len = s.length();
            if (len < 2) {
                return s;
            }

            //dp记录回文子串起始位置和结束位置的下标
            boolean[][] dp = new boolean[len][len];
            int maxLen = 1;
            int begin = 0;
            char[] str = s.toCharArray();

            //对角线上的值都为true，因为单个字符也是一个回文子串
            for(int i = 0;i < len;i++){
                dp[i][i] = true;
            }

            for(int j = 1;j < len;j++) {
                for(int i = 0;i < j;i++) {
                    if(str[i] == str[j]) {
                        //如果子串长度j-1-(i+1)+1 < 2，则为回文串，否则转移状态
                        if(j - i < 3) {
                            dp[i][j] = true;
                        }
                        else {
                            dp[i][j] = dp[i+1][j-1];
                        }
                    }
                    //如果为回文子串，则计算最大长度，记录长度
                    if (dp[i][j]) {
                        int curLen = j - i + 1;
                        if (curLen > maxLen) {
                            maxLen = curLen;
                            begin = i;
                        }
                    }
                }
            }
            return s.substring(begin,begin + maxLen);
        }
    }
}
