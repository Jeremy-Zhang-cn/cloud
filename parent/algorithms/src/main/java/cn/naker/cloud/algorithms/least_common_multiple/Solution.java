package cn.naker.cloud.algorithms.least_common_multiple;

import java.util.Scanner;

/**
 * HJ108 求最小公倍数
 *
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 *
 * 示例1
 * 输入：
 * 5 7
 *
 * 输出：
 * 35
 * 复制
 * 示例2
 * 输入：
 * 2 4
 *
 * 输出：
 * 4
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String nums = scanner.nextLine();
			String[] split = nums.split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			System.out.println(lcm(a,b));
		}
		scanner.close();
	}


	public static int lcm(int a, int b) {
		// 公式法 求最小公倍数 -> a 和 b 的最小公倍数等于 a与b的乘积除以二者的最大公约数
		return (a * b) / gcd(a, b);
	}

	public static int gcd(int a, int b) {
		// 辗转相除法求最大公约数
		// a 除以 b得余数 用余数再与b相除 递归调用
		if (b == 0) return a;
		return gcd(b, a % b);
	}

}
