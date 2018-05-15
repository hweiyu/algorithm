package com.hwy.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/15 16:39
 **/
public class AllCombine {

    public static void main(String[] args) {

        List<String> dd = new ArrayList<>();
        dd.add("a");
        dd.add("b");
        dd.add("c");
        dd.add("d");

        List<List<String>> result = allCombine(dd);

        for (List<String> list : result) {
            for (String s : list) {
                System.out.print(s + ",");
            }
            System.out.println();
        }

    }

    private static List<List<String>> allCombine(List<String> origin) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < origin.size(); i++) {
            for (int j = i; j < origin.size(); j++) {
                result.add(origin.subList(i, j + 1));
            }
        }
        return result;
    }
}
