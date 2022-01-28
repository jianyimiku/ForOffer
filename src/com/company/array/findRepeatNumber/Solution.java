package com.company.array.findRepeatNumber;

/**
 * @author ：sjq
 * @date ：Created in 2022/1/21 8:54 下午
 * @description：003-数组中重复出现的数字
 * @modified By：
 * @version: $
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class Solution {

    public static void main(String[] args) {
        int[] params = new int[]{2, 3, 1, 0, 2, 5, 3};
        Solution solution = new Solution();
        System.out.println(solution.findRepeatNumberWithHash(params));
    }

    /**
     * 使用Hash表的方法来找出
     *
     * @param nums
     * @return
     */
    public int findRepeatNumberWithHash(int[] nums) {
        // 根据题意输入的数据肯定是存在的
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
            if (arr[nums[i]] > 1) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 鸽巢原理
     * [2, 3, 1, 0, 2, 5, 3]
     * m 表示当前的数字 i表示索引
     * 当第一个数字 m != i的时候 看看nums[m] 是否等于 m 如果是我们找到了一个重复的数字 如果不是那么把m
     * 放到他本来的位置
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) return nums[i];
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }
}
