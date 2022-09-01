package cn.naker.cloud.algorithms.str_sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * HJ14 字符串排序
 *
 * 给定 n 个字符串，请对 n 个字符串按照字典序排列。
 * 数据范围： 1<=n<=1000,字符串长度满足 1<=len<=100
 *
 * 输入第一行为一个正整数n(1<=n<=1000),下面n行为n个字符串(字符串长度<=100),字符串中只含有大小写字母。
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 *
 * 输入： 9
 *  cap
 *  to
 *  cat
 *  card
 *  two
 *  too
 *  up
 *  boat
 *  boot
 * 输出： boat
 *  boot
 *  cap
 *  card
 *  cat
 *  to
 *  too
 *  two
 *  up
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int m = Integer.parseInt(scanner.nextLine());
			if (m > 0) {
				String[] strings = new String[m];
				for (int i = 0; i < m; i++) {
					strings[i] = scanner.nextLine();
				}
				Arrays.sort(strings);
				for (String str : strings) {
					System.out.println(str);
				}
			}
		}
		scanner.close();
	}

}
