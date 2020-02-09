package com.lyldelove.problemset.algorithms.part1;

/**
 * 2、两数之和
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */

/**
 * 链表节点类
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyNode = new ListNode(0); //申明哑结点，表示新链表的头节点，是不动的
        ListNode moveNode = dummyNode; //申明移动的结点，沿着新链表往后延伸，初始值为头节点
        ListNode node1 = l1, node2 = l2;
        int carry = 0; //进位的数字
        int value1;
        int value2;
        int sum;

        while(node1 != null || node2 != null) {
            value1 = node1 == null ? 0 : node1.val;
            value2 = node2 == null ? 0 : node2.val;
            sum = value1 + value2 + carry;
            //计算本位数
            moveNode.next = new ListNode(sum % 10);
            moveNode = moveNode.next;
            //重新计算进位
            carry = sum / 10;
            //结点往后移动
            if(node1 != null) node1 = node1.next;
            if(node2 != null) node2 = node2.next;
        }

        //最后相加的数如果再进一位
        if(carry > 0) {
            moveNode.next = new ListNode(carry);
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        //第一个链表
        ListNode aNode1 = new ListNode(2);
        ListNode aNode2 = new ListNode(4);
        ListNode aNode3 = new ListNode(3);
        aNode1.next = aNode2;
        aNode2.next = aNode3;
        //第二个链表
        ListNode bNode1 = new ListNode(5);
        ListNode bNode2 = new ListNode(6);
        ListNode bNode3 = new ListNode(4);
        bNode1.next = bNode2;
        bNode2.next = bNode3;

        new AddTwoNumbers().addTwoNumbers(aNode1, bNode1);
    }
}

/**
 * 解题思路：
 *  1、申明哑结点，且新链表的头节点为哑结点
 *  2、申明移动结点，从头节点往后延伸
 *  3、申明进位标识，当2个数之和>9时，下一个循环需要+1
 *  4、循环2个链表，往后延伸新链表
 * 时间复杂度：O(max(m, n))
 * 空间复杂度：O(max(m, n))
 */


