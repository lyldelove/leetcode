package com.lyldelove.algorithms.phase1;

import java.util.HashMap;

/**
 * @author lyldelove
 * @title LC0001 两数之和
 * @tag 哈希表
 * @url https://leetcode-cn.com/problems/two-sum/
 * @date 2020/3/22 22:04
 */
public class LC0001 {

    private int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            //判断(目标值-当前元素值)是否存在于map中
            int result = target - nums[i];
            if(map.containsKey(result)) {
                return new int[] {map.get(result), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        LC0001 lc = new LC0001();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] ints = lc.twoSum(nums, target);

        System.out.println(ints);
    }
}
