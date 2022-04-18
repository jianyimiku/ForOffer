package com.company.array.search;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 输入: nums = [5,8,8,8,10], target = 8
 * 输出: 3
 */
class Solution {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = nums.length - 1;

        int targetIndex = -1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            // 说明找到了
            if (nums[middle] == target) {
                targetIndex = middle;
                break;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        // 表示没有找到
        if (targetIndex == -1) {
            return res;
        }

        int i = targetIndex;
        int j = targetIndex;

        while (j < nums.length && nums[j] == target) {
            res++;
            j++;
        }

        while (i > 0 && nums[i - 1] == target) {
            res++;
            i--;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }
}