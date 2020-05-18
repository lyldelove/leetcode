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

        //确保length1 <= length2
        if(nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int length1 = nums1.length;
        int length2 = nums2.length;
        int half = (length1 + length2 + 1) / 2;

        int min = 0;
        int max = length1;

        //二分查找
        while (min <= max) {
            int i = (min + max) / 2;
            int j = half - i;

            if(i < max && nums2[j - 1] > nums1[i]) {//2大，i往右
                min = i + 1;
            } else if(i > min && nums1[i - 1] > nums2[j]) {//1大，i往左
                max = i - 1;
            } else {//满足条件
                //取左边最大值
                int maxLeft = 0;
                if(i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ( (length1 + length2) % 2 == 1 ) {
                    return maxLeft;
                }

                //取右边最小值
                int minRight = 0;
                if(i == length1) {
                    minRight = nums2[j];
                } else if (j == length2) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        // 2个有序数组的重新排序
        // 题目要求时间复杂度为O(log(m + n))
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(new LC0004().findMedianSortedArrays(nums1, nums2));
    }
}
