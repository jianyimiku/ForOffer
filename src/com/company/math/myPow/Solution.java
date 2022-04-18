package com.company.math.myPow;

/**
 * @author ：sjq
 * @date ：Created in 2022/4/18 09:45
 * @description：数值的整数次方 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * @modified By：
 * @version: $
 * <p>
 * 快速幂
 * <p>
 * X^N = (X^(N / 2)) ^ 2 如果为奇数还需要乘以 X
 */
public class Solution {
    public double myPow(double x, int n) {
        return n >= 0 ? pow(x, n) : 1 / pow(x, -n);
    }

    public double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double res = pow(x, n / 2);
        return n % 2 == 0 ? res * res : res * res * x;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2.0, -2147483648));
    }
}
