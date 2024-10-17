package com.example.dailylearning.test;

import com.alibaba.fastjson.JSON;

/**
* 两数之和
* */
public class Lszh {

    public static void main(String[] args) {
        int[] nums = new int[]{3,3};
        int target = 6;
        int[] ints = twoSum(nums, target);
        System.out.println(JSON.toJSONString(ints));

    }

    public static int[] twoSum(int[] nums, int target) {
        int j;
        int y = 0;
        for(int i = 0; i < nums.length; i++){

            j = nums[y];

            for(int k = y + 1; k < nums.length; k++){
                boolean flag = target - nums[k] == j;
                if(flag){
                    return new int[]{y,k};
                }
                if ( k == nums.length -1){
                    y++;
                }
            }
        }
        return new int[]{};
    }
}
