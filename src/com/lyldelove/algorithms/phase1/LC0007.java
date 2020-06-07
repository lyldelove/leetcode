package com.lyldelove.algorithms.phase1;

/**
 * @author lyldelove
 * @title LC0007 整数反转
 * @url https://leetcode-cn.com/problems/reverse-integer/
 * @tag 整数模拟堆栈的入/出推操作
 * @date 2020/6/6 7:09
 */
public class LC0007 {

    public int reverse(int x) {
        int result = 0;

        while(x != 0) {
            //取出x的栈顶元素
            int pop = x % 10;
            //出去栈顶元素后的x
            x = x / 10;

            //判断溢出
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                return 0;
            }

            if(result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) {
                return 0;
            }

            //将取出的栈顶元素入栈到result栈中，(result * 10 + pop)是可能溢出的，需要做特殊校验
            result = result * 10 + pop;

        }

        return result;
    }

    public static void main(String[] args) {
        int x = -1020;
        System.out.println(new LC0007().reverse(x));
    }
}
