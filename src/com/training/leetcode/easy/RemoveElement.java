package com.training.leetcode.easy;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int last=0;
        for (int i =0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = nums.length-1; j >= 0; j--) {
                    if (nums[j-last] != val) {
                        nums[i] = nums[j];
                        last++;
                        break;
                    }
                }
            }
        }

        return last;
    }
    public int removeElement2(int[] nums, int val) {
        int count = 0;
        for (int i=0; i< nums.length; i++) {
            if (nums[i]== val) count++;
        }
        return nums.length - count;
    }public int removeElement3(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    public int removeElement4(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
    public int removeElement5(int[] nums, int val) {
        int i = 0;
        for (int elem: nums){
            if (elem != val){
                nums[i] = elem;
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveElement test = new RemoveElement();
        int nums[]={2,3,4,2,3};
        int nums2[]={3,2,2,3};
        int nums3[]={0,1,2,2,3,0,4,2};
        //System.out.println(test.removeElement(nums, 3));
        //System.out.println(test.removeElement3(nums2, 3));
        System.out.println(test.removeElement(nums3, 2));

    }
}

/*
Given an array nums and a value val, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeElement(nums, val);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}


Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2]
Explanation: Your function should return length = 2, with the first two elements of nums being 2.
It doesn't matter what you leave beyond the returned length. For example if you return 2 with nums = [2,2,3,3] or nums = [2,2,0,0], your answer will be accepted.
Example 2:

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3]
Explanation: Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4. Note that the order of those five elements can be arbitrary. It doesn't matter what values are set beyond the returned length.


Constraints:

0 <= nums.length <= 100
0 <= nums[i] <= 50
0 <= val <= 100
 */
