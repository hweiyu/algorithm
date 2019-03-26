package com.hwy.algorithm.leetcode;

/**
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @author huangweiyu
 * @version V1.0
 * @Title 描述
 * @Description 描述
 * @date 2019/3/26 15:01
 **/
public class T004FindMidNum {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double mid1 = getMidNum(nums1);
        double mid2 = getMidNum(nums2);
        System.out.println((mid1 + mid2) / 2);
    }

    private static double getMidNum(int[] arr) {
        double num;
        int len = arr.length;
        if (len > 1) {
            if (arr.length % 2 == 1) {
                num = arr[(arr.length + 1) / 2];
            } else {
                num = (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2.0;
            }
        } else {
            num = arr[0];
        }
        return num;
    }
}
