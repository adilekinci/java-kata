package com.training.leetcode.easy;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        //[0,0,1,1,1,2,2,3,3,4]
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray test = new RemoveDuplicatesFromSortedArray();
        int nums[]={0,0,1,1,1,2,2,3,3,4};
        System.out.println(test.removeDuplicates(nums));
    }
}

