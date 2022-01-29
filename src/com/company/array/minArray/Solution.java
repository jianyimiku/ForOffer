package com.company.array.minArray;

/**
 * 11 - 旋转数组的最小数字
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * <p>
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，
 * 并按上述情形进行了一次旋转。请返回旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。  
 * <p>
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * <p>
 * 第一种方法 显而易见 O(N) 从头到尾遍历找出最小值 最差情况需要遍历到末尾 N
 * <p>
 * 第二种: 二分查找
 */
class Solution {
    public static int minArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            // 如果当前取到的值比right大 那么最小值肯定在左边
            if (numbers[middle] > numbers[right]) {
                left = middle + 1;
            } else if (numbers[middle] < numbers[right]) {
                // 最小值可能还在左边 存在于区间[left....middle] 中
                right = middle;
            } else if (numbers[middle] == numbers[right]) {
                // 无法判断
                right = right - 1;
            }
        }
        return numbers[left];
    }
}