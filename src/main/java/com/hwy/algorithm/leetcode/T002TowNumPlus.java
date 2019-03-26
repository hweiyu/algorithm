package com.hwy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author huangweiyu
 * @version V1.0
 * @Title 描述
 * @Description 描述
 * @date 2019/3/26 13:40
 **/
public class T002TowNumPlus {

    private List<Integer> numByte = new ArrayList<>(10);

    public T002TowNumPlus(String num) {
        for (String s : num.split("")) {
            numByte.add(Integer.valueOf(s));
        }
        Collections.reverse(numByte);
    }

    public T002TowNumPlus(List<Integer> numList) {
        this.numByte = numList;
    }

    public T002TowNumPlus plus(T002TowNumPlus num) {
        List<Integer> result = new ArrayList<>(10);
        int thisLen = this.numByte.size();
        int thatLen = num.getNumByte().size();
        int maxLen = Integer.max(thisLen, thatLen);
        //进位
        int plusByte = 0;
        //当前位的累加值
        int curPlus;
        for (int i = 0; i < maxLen; i++) {
            curPlus = 0;
            if (plusByte > 0) {
                curPlus += plusByte;
                plusByte = 0;
            }
            if (i < thisLen) {
                curPlus += this.numByte.get(i);
            }
            if (i < thatLen) {
                curPlus += num.getNumByte().get(i);
            }
            if (curPlus >= 10) {
                result.add(curPlus % 10);
                plusByte = 1;
            } else {
                result.add(curPlus);
            }
        }
        if (plusByte > 0) {
            result.add(plusByte);
        }
        return new T002TowNumPlus(result);
    }

    public List<Integer> getNumByte() {
        return numByte;
    }

    @Override
    public String toString() {
        if (null != numByte) {
            StringBuilder buf = new StringBuilder();
            for (Integer num : numByte) {
                buf.append(" -> ").append(num);
            }
            return buf.substring(4);
        }
        return "null";
    }

    public static void main(String[] args) {
//        342 + 965 = 1307
        T002TowNumPlus num1 = new T002TowNumPlus("342");
        T002TowNumPlus num2 = new T002TowNumPlus("965");
        System.out.println(num1.plus(num2));
    }
}
