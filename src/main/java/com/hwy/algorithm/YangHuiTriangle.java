package com.hwy.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *                1
 *              1   1
 *            1   2   1
 *          1   3   3   1
 *        1   4   6   4   1
 *
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/17 11:39
 **/
public class YangHuiTriangle {

    public static void main(String[] args) {
        int layer = 10;
        List<List<Integer>> result = new ArrayList<>();
        yangHui(layer, result);
        print(result);
    }

    private static void yangHui(int layer, List<List<Integer>> result) {
        List<Integer> curList = new ArrayList<>(layer);
        if (layer == 1) {
            curList.add(1);
        } else {
            yangHui(layer - 1, result);
            List<Integer> preList = result.get(layer - 2);
            for (int i = 0; i < layer; i++) {
                if (i == 0 || i == layer - 1) {
                    curList.add(1);
                } else {
                    curList.add(preList.get(i - 1) + preList.get(i));
                }
            }
        }
        result.add(curList);
    }

    private static void print(List<List<Integer>> result) {
        String space = "      ";
        String str;
        int len = result.size();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                System.out.print(space.substring(space.length() / 2));
            }
            for (Integer cur : result.get(i)) {
                str = space + cur;
                System.out.print(str.substring(str.length() - 6, str.length()));
            }
            System.out.println();
        }
    }
}
