package cn.naker.cloud.algorithms.parentheses_depth;

import java.util.Scanner;

/**
 * LeetCode 1614 括号的最大嵌套深度
 * 给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			System.out.printf("max depth is %d\n", maxDepth(scanner.nextLine()));
		}
		scanner.close();
	}

	public static int maxDepth(String s) {
		// 注意 给定的字符串就是合法的括号对 所以只需要统计左括号深度 可利用栈 遇到左括号压入栈中 判断当前最大深度与栈深度关系 取最大值
		char[] chars = s.toCharArray();
		int max = 0, size = 0;
		for (char c : chars) {
			if (c == '(') {
				size++;
				max = Math.max(max, size);
			} else if (c == ')') {
				size--;
			}
		}
		return max;
	}

}
