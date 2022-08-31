package cn.naker.cloud.algorithms.jump_floor;

import java.util.Scanner;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int target = scanner.nextInt();
			System.out.println(jumpFloor(target));
		}
		scanner.close();
	}


	public static int jumpFloor(int target) {
		if (target == 1 || target == 2) return target;
		return jumpFloor(target - 1) + jumpFloor(target - 2);
	}
}
