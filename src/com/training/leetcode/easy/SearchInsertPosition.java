package com.training.leetcode.easy;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int i=0;
        for (; i<nums.length; i++) {
            if (nums[i] >= target) {
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        SearchInsertPosition test = new SearchInsertPosition();
        System.out.println(test.searchInsert(new int[]{1,3,5,6},5));
        System.out.println(test.searchInsert(new int[]{1,3,5,6},2));
        System.out.println(test.searchInsert(new int[]{1,3,5,6},7));
        System.out.println(test.searchInsert(new int[]{1,3,5,6},0));
    }
}

/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
Example 4:

Input: nums = [1,3,5,6], target = 0
Output: 0
Example 5:

Input: nums = [1], target = 0
Output: 0


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104

 */