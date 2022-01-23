package com.model;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ：sjq
 * @date ：Created in 2022/1/21 10:39 上午
 * @description：基础测试数组
 * @modified By：
 * @version: $
 */
public class BaseModel {
    public static int[] nums;
    public static Random random;

    static {
        random = new Random();
    }

    public static void generateNum() {
        nums = new int[1000000];
        for (int i = 0; i < 10e+5; i++) {
            nums[i] = random.nextInt(Integer.MAX_VALUE);
        }
    }


    public static void main(String[] args) {
        generateNum();
        long start = System.currentTimeMillis();
        // 选择排序
        for (int i = 0; i < nums.length; i++) {
            // 最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]){
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        long end = System.currentTimeMillis();
        System.out.println(start - end);
        System.out.println(Arrays.toString(nums));
    }
}
