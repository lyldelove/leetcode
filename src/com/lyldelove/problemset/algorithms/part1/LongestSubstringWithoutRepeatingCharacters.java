package com.lyldelove.problemset.algorithms.part1;

import java.util.HashMap;
import java.util.Map;

/*
 * 3、无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 解法：滑动窗口
 *  head 头指针
 *  tail 尾指针
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

    private int lengthOfLongestSubstring(String s) {

        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int head = 0, tail = 0; tail < s.length(); tail ++) {
            char tailElement = s.charAt(tail);

            if(map.containsKey(tailElement)) {
                head = Math.max(map.get(tailElement), head); //
            }

            result = Math.max(result, tail - head + 1); //
            map.put(s.charAt(tail), tail + 1); //
        }

      return result;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        int result = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}

/**
 * 扩展：循环字符串的几种方式
 * 1 charAt()
 * 2 getBytes()
 * 3 toCharArray()
 * 4 substring
 */