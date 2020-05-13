package com.lyldelove.algorithms.phase1;

/**
 * @author lyldelove
 * @title LC0004 寻找2个有序数组的中位数
 * @url https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @tag
 * @date 2020/4/12 6:26
 */
public class LC0004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int half = (length1 + length2 + 1) / 2;

        int min = 0;
        int max = length1;

        //二分查找
        while (min <= max) {
            int i = (min + max) / 2;
            int j = half - i;

            //2大
            if(nums2[j - 1] > nums1[i]) {

            }
        }
        // 2个有序数组的重新排序
        // 题目要求时间复杂度为O(log(m + n))
        return 0;
    }

    public static void main(String[] args) {

    }
}
