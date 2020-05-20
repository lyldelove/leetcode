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
     * 方法1 最长公共子串
     * @param s
     * @return
     */
    public String longestCommonSubstring(String s) {
        return "";
    }

    /**
     * 方法2 暴力法，穷举
     * @param s
     * @return
     */
    public String exhaustiveAttack(String s) {

        return "";
    }

    public String longestPalindrome(String s) {
        return longestCommonSubstring(s);
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(new LC0005().longestPalindrome(s));
    }
}
