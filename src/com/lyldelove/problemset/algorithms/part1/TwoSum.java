package com.lyldelove.problemset.algorithms.part1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1、两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class TwoSum {

    /**
     * 我的解答
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i ++) {
            int diff = target - nums[i];
            Integer value = map.get(diff);
            if(value != null) {
                return new int[] {value, i};
            }
            map.put(nums[i], i);
        }

        return null;
    }

    /**
     * 官方解答
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumByOwner(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        new TwoSum().twoSum(nums, target);
        new TwoSum().twoSumByOwner(nums, target);
    }
}

/**
 * 解题思路：
 *  循环数组，采用差值（target-元素）进行查找，差值若在map中已经存在，就找到符合条件的值了，
 *  若没有找到，把当前循环的数组元素-索引存入map中，供下次查找
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
