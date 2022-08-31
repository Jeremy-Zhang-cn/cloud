package cn.naker.cloud.algorithms.str_reverse;

import java.util.Scanner;

/**
 * HJ106 字符逆序
 *
 * 将一个字符串str的内容颠倒过来，并输出。
 *
 * 数据范围：1≤len(str)≤10000
 * 输入描述：
 * 输入一个字符串，可以有空格
 *
 * 输出描述：
 * 输出逆序的字符串
 *
 *
 * 示例1
 * 输入：
 * I am a student
 * 输出：
 * tneduts a ma I
 *
 * 示例2
 * 输入：
 * nowcoder
 * 输出：
 * redocwon
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			reverse(scanner.nextLine());
		}
		scanner.close();
	}

	public static void reverse(String str) {
		System.out.println(new StringBuilder(str).reverse().toString());
	}

}
