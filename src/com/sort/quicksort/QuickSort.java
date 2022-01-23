package com.sort.quicksort;

import com.model.BaseModel;

import java.util.Arrays;

/**
 * @author ：sjq
 * @date ：Created in 2022/1/22 2:04 下午
 * @description：快速排序
 * @modified By：
 * @version: $
 */
public class QuickSort extends BaseModel {

    public static void main(String[] args) {
        generateNum();
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        // 获取parition索引值
        int partition = partition(nums, left, right);
        quickSort(nums, left, partition - 1);
        quickSort(nums, partition + 1, right);
    }


    private static int partition(int[] nums, int left, int right) {
        int temp = nums[left];
        int j = left;

        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < temp) {
                swap(nums, i, j + 1);
                j++;
            }
        }
        swap(nums, left, j);
        return j;
    }


    private static void swap(int[] nums, int start, int end) {
        int temp = nums[end];
        nums[end] = nums[start];
        nums[start] = temp;
    }
}
