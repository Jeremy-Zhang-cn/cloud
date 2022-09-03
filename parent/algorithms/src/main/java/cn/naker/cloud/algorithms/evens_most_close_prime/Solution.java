package cn.naker.cloud.algorithms.evens_most_close_prime;

import java.util.Scanner;

/**
 * HJ60 查找组成一个偶数最接近的两个素数
 *
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对。
 *
 * 输入描述：
 * 输入一个大于2的偶数
 *
 * 输出描述：
 * 从小到大输出两个素数
 *
 * 示例1
 * 输入：
 * 20
 *
 * 输出：
 * 7
 * 13
 *
 * 示例2
 * 输入：
 * 4
 *
 * 输出：
 * 2
 * 2
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int num = Integer.parseInt(scanner.nextLine());
			divide(num);
		}
		scanner.close();
	}

	public static void divide(int num) {
		int[] res = new int[2];
		int min = Integer.MAX_VALUE;
		for (int i = 2; i <= num; i++) {
			if (isPrime(i) && isPrime(num - i)) {
				int tmp = Math.min(min, Math.abs(num - i - i));
				if (tmp < min) {
					min = tmp;
					res[0] = i;
					res[1] = num - i;
				}
			}
		}
		System.out.printf("%d\n%d\n", res[0], res[1]);
	}

	/**
	 * 素数判断
	 */
	public static boolean isPrime(int num) {
		// 2或者3 直接返回true
		if (num == 2 || num == 3) return true;
		// 偶数直接返回false
		if (num % 2 == 0 || num == 1) return false;
		// 能被偶数整除的一定是偶数 因此从3开始 以2为步长 只针对除数为奇数的情况做操作 减少判断次数
		for (int i = 3; i <= Math.sqrt(num); i += 2) {
			if (num % i == 0) return false;
		}
		return true;
	}

}
