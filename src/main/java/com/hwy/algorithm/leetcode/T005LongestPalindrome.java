package com.hwy.algorithm.leetcode;

import java.util.*;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author huangweiyu
 * @version V1.0
 * @Title 描述
 * @Description 描述
 * @date 2019/3/26 15:26
 **/
public class T005LongestPalindrome {

    public static void main(String[] args) {
        String str = "babad";
        String[] strArr = str.split("");
        int len = str.length();
        List<String> max = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            List<String> t = new ArrayList<>(len);
            t.add(strArr[i]);
            for (int j = i + 1; j < len; j++) {
                t.add(strArr[j]);
                if (isPalindrome(t) && t.size() > max.size()) {
                    max.clear();
                    max.addAll(t);
                }
            }
        }
        print(max);
    }

    private static boolean isPalindrome(List<String> list) {
        List<String> t = new ArrayList<>(list);
        Collections.reverse(t);
        return list.equals(t);
    }

    private static void print(List<String> list) {
        StringBuilder buf = new StringBuilder();
        for (String s : list) {
            buf.append(s);
        }
        System.out.println(buf.toString());
    }
}
