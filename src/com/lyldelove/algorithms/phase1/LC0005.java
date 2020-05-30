package com.lyldelove.algorithms.phase1;

/**
 * @author lyldelove
 * @title LC0005 最长回文子串
 * @url https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @tag 动态规划
 * @date 2020/5/20 22:10
 */
public class LC0005 {

    /**
     * 方法1 暴力法，穷举
     * 时间复杂度： O(n^3)
     * 空间复杂度： O(1)
     * @param s
     * @return
     */
    public String exhaustiveAttack(String s) {
        String longestString = "";
        //获取所有的子字符串
        for(int i = 0; i < s.length(); i ++) {
            for(int j = i + 1; j < s.length() + 1; j ++) {
                //substring是[)的，左开右闭的
                String substring = s.substring(i, j);
                if(validPalindromic(substring) && substring.length() > longestString.length()) {
                    longestString = substring;
                }
            }
        }
        return longestString;
    }

    /**
     * 判断是否为回文字符串
     * @param string
     * @return
     */
    public boolean validPalindromic(String string) {
        //倒装s
        String reverse = new StringBuilder(string).reverse().toString();
        return string.equals(reverse);
    }

    /**
     * 动态规划算法，空间换时间
     * 时间复杂度：
     * 空间复杂度：
     * @param s
     * @return
     */
    public String dynamicProgramming(String s) {
        //1、设计状态 dp[i][j]表示子串s[i, j]是否为回文串
        //2、状态转移方程 dp[i][j] = dp[i + 1][j - 1] and s[i] == s[j]
        //3、边界条件 子串长度为1，  (j - 1) - (i + 1) + 1 < 2 => j - i < 3
        //最终的条件为：dp[i][j] = s[i] == s[j] and (dp[i + 1][j - 1] or j - i < 3)
        //边界条件设想不一样，最终的状态方程就不一样
        //初始化dp[i][i] = true
        int len = s.length();
        //特殊情况
        if (len < 2) {
            return s;
        }
        //最大回文子串的长度
        int maxLen = 1;
        //最大回文子串开始的索引
        int begin = 0;

        //1、设计状态 dp[i][j]表示子串s[i, j]是否为回文串

        //2、初始化，二维填表，对角线上的永远是true
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        //3、状态转移，二维填表，先填左下角，先一列一列的填写，再一行一行的填，保证左下方的单元格先进行计算
        char[] chars = s.toCharArray();

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                //头尾字符不相等，不是回文串
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    //考虑头尾去掉以后没有字符剩余，或者剩下一个字符的时候，肯定是回文串
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        //状态转移
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                //只要dp[i][j] == true 成立，表示s[i...j] 是否是回文串，此时更新记录回文长度和起始位置
                if(dp[i][j] && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    /**
     * 中心扩散法
     * 枚举所有可能的回文子串的中心位置
     * 中心位置可能是一个字符，也有可能是2个相邻的字符
     * @param s
     * @return
     */
    public String expandCenter(String s) {
        int len = s.length();
        //特殊情况
        if (len < 2) {
            return s;
        }
        //最大回文子串的长度
        int maxLen = 1;
        //最大回文子串开始的索引
        int begin = 0;

        char[] chars = s.toCharArray();

        for (int i = 0; i < len - 1; i++) {
            int oddLen = expand(chars, i, i);
            int evenLen = expand(chars, i, i + 1);

            int curMaxLen = Math.max(oddLen, evenLen);

            if(curMaxLen > maxLen) {
                maxLen = curMaxLen;
                begin = i - (maxLen - 1) / 2;
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    /**
     * 从中心往两边扩散，寻找左右两边一样的子串
     * @param chars
     * @param left
     * @param right
     * @return
     */
    public int expand(char[] chars, int left, int right) {
        int len = chars.length, l = left, r = right;

        while(l >= 0 && r < len && chars[l] == chars[r]) {
            l --;
            r ++;
        }

        return r - l - 1;
    }

    public String longestPalindrome(String s) {
        return expandCenter(s);
    }

    public static void main(String[] args) {
        String s = "abncd";
        System.out.println(new LC0005().longestPalindrome(s));
    }
}
