package com.company.array.missingNumber;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 输入: [0,1,2,3,5,6,7,8,9]
 * 输出: 8
 */
class Solution {
    public static int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == middle) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0,1,3}));
    }
}