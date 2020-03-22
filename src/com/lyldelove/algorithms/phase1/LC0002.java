package com.lyldelove.algorithms.phase1;

import com.lyldelove.algorithms.common.ListNode;

/**
 * @author lyldelove
 * @title LC0002 两数相加
 * @tag 链表 哑结点
 * @url https://leetcode-cn.com/problems/add-two-numbers/
 * @date 2020/3/22 22:07
 */
public class LC0002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //初始化一个哑结点
        ListNode dummyNode = new ListNode(0);
        //设置指针进行移动
        ListNode curr = dummyNode;

        //定义进位
        int carry = 0;

        //同时循环2个链表
        while(l1.next != null || l2.next != null) {
            int value1 = l1 != null ? l1.value : 0;
            int value2 = l2 != null ? l2.value : 0;
            int sum = carry + value1 + value2;

            //判断进位
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);

            //往后移动
            curr = curr.next;

            if(l1 != null) {
                l1 = l1.next;
            }

            if(l2 != null) {
                l2 = l2.next;
            }
        }

        //循环出来后进位如果是1，需要再向后延展一位1
        if(carry > 0) {
            curr.next = new ListNode(1);
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        LC0002 lc = new LC0002();
    }
}
