package com.hwy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author huangweiyu
 * @version V1.0
 * @Title 描述
 * @Description 描述
 * @date 2019/3/27 10:40
 **/
public class T007NumReverse {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
        System.out.println(reverse(-123));
        System.out.println(reverse(123));
        System.out.println(reverse(120));
    }

    private static int reverse(int x) {
        if (Integer.MIN_VALUE == x) {
            return 0;
        }
        String numStr = String.valueOf(x);
        if (x < 0) {
            numStr = numStr.substring(1);
        }
        List<Character> list = new ArrayList<>(32);
        for (char c : numStr.toCharArray()) {
            list.add(c);
        }
        StringBuilder buf = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            buf.append(list.get(i));
        }
        String r = x < 0 ? ("-" + buf.toString()) : buf.toString();
        boolean isRange = r.compareTo(String.valueOf(Integer.MIN_VALUE)) >= 0
                && r.compareTo(String.valueOf(Integer.MAX_VALUE)) <= 0;
        return isRange ? Integer.valueOf(r) : 0;
    }
}
