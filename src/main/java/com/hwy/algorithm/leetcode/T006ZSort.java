package com.hwy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * @author huangweiyu
 * @version V1.0
 * @Title 描述
 * @Description 描述
 * @date 2019/3/27 9:11
 **/
public class T006ZSort {

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 3));
        System.out.println(convert("LEETCODEISHIRING", 4));
        System.out.println(convert("AB", 1));
    }

    private static String convert(String s, int numRows) {
        List<List<Character>> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>(10));
        }
        int index = 0;
        boolean isAsc = true;
        for (char c : s.toCharArray()) {
            list.get(index).add(c);
            if (numRows > 1) {
                if (index == 0) {
                    isAsc = true;
                } else if (index == numRows - 1) {
                    isAsc = false;
                }
                if (isAsc) {
                    index++;
                } else {
                    index--;
                }
            }
        }
        StringBuilder buf = new StringBuilder();
        for (List<Character> characters : list) {
            for (Character character : characters) {
                buf.append(character);
            }
        }
        return buf.toString();
    }
}
