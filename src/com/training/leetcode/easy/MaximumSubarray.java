package com.training.leetcode.easy;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int[] sum =  new int[nums.length];
        sum[0] = nums[0];

        for(int i=1; i<nums.length; i++){
            sum[i] = Math.max(nums[i], sum[i-1] + nums[i]);
            result = Math.max(result, sum[i]);
        }

        return result;
    }

    public int maxSubArray2(int[] nums) {
        int result = nums[0];
        int sum = nums[0];

        for(int i=1; i<nums.length; i++){
            sum = Math.max(nums[i], sum + nums[i]);
            result = Math.max(result, sum);
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumSubarray test = new MaximumSubarray();
        System.out.println(test.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(test.maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
