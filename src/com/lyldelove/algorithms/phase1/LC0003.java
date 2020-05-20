package com.lyldelove.algorithms.phase1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lyldelove
 * @title LC0003 无重复字符的最长子串
 * @url https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @tag 滑动窗口SlidingWindow HashSet
 * @date 2020/4/5 8:25
 */
public class LC0003 {

    int lengthOfLongestSubstringMethod1(String s) {
        //初始化滑动窗口索引i, j, 结果
        int i = 0, j = 0, result = 0;
        //新建HashSet存放子串
        Set<Character> set = new HashSet<>();

        //循环串
        while(i < s.length() && j < s.length()) {
            if(set.contains(s.charAt(j))) {
                //先删除i
                set.remove(s.charAt(i));
                //i往前滑动
                i ++;
            } else {
                //j存放到Set中
                set.add(s.charAt(j));
                //j往前滑动
                j ++;
                //计算结果
                result = Math.max(result, j - i);
            }
        }

        return result;
    }

    int lengthOfLongestSubstringMethod2(String s) {
        //定义结果
        int result = 0;
        //新建K-V存放元素-索引
        Map<Character, Integer> map = new HashMap<>();

        //循环数组
        for(int i = 0, j = 0; j < s.length(); j ++) {
            Character currentChar = s.charAt(j);

            if(map.containsKey(currentChar)) {
                //存在时，直接跳过i-j'
                i = Math.max(map.get(currentChar) + 1, i);
            }
            result = Math.max(result, j - i + 1);
            map.put(currentChar, j);
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int len = new LC0003().lengthOfLongestSubstringMethod2(s);
        System.out.println(len);
    }
}
