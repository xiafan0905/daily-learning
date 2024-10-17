package com.example.dailylearning.leetcode.面试经典150题;

public class One {

    /**
    *  合并两个有序数组
    * */
    public static void main(String[] args) {
        int[] nums1  =new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 =new int[]{2,5,6};
        int n = 3;

    }

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {

        if (n==0 && m > 0){
            return nums1;
        }
        if (m==0 && n > 0){
            return nums1 = nums2;
        }
        return nums1;
    }
}
