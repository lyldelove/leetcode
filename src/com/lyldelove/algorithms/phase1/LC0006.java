package com.lyldelove.algorithms.phase1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyldelove
 * @title LC0006 Z字形变换
 * @url https://leetcode-cn.com/problems/zigzag-conversion/
 * @tag
 * @date 2020/5/31 7:22
 */
public class LC0006 {

    /**
     * 方法1 根据原始字符串循环，将每个字符添加到合适的行
     * @param s
     * @param numRows
     * @return
     */
    public String convertByOriginal(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        //初始化目的字符串行数据
        List<StringBuilder> rowList = new ArrayList<>();

        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rowList.add(new StringBuilder());
        }

        int currentRow = 0;
        char[] chars = s.toCharArray();

        boolean goingDown = false;
        for (char c : chars) {
            rowList.get(currentRow).append(c);

            if(currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : rowList) {
            result.append(stringBuilder);
        }

        return result.toString();
    }

    /**
     * 方法2 按照目的字符串规律，挑选字符
     * @param s
     * @param numRows
     * @return
     */
    public String convertByResult(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int len = s.length();

        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < len; j += cycleLen) {
                sb.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < len)
                    sb.append(s.charAt(j + cycleLen - i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwxyz";
        int row = 5;

        System.out.println(new LC0006().convertByOriginal(s, row));
        System.out.println(new LC0006().convertByResult(s, row));
    }
}
