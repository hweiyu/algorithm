package com.hwy.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author huangweiyu
 * @version V1.0
 * @Title 描述
 * @Description 描述
 * @date 2019/3/26 14:38
 **/
public class T003FindMaxSubString {

    public static void main(String[] args) {
        String str = "pwwkew";
        String[] strArr = str.split("");
        int len = str.length();
        int max = 0;
        for (int i = 0; i < len; i++) {
            int count = 0;
            Set<String> t = new HashSet<>(len);
            for (int j = i; j < len; j++) {
                if (t.add(strArr[j])) {
                    count++;
                } else {
                    break;
                }
            }
            max = Integer.max(max, count);
        }

        System.out.println("max sub string length:" + max);
    }
}
