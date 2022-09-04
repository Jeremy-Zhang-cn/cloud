package cn.naker.cloud.algorithms.str_permutation1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * LeetCode 面试题 08.07. 无重复字符串的排列组合
 *
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 *
 * 示例1:
 *
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 * 示例2:
 *
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 *
 */
public class Solution {


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			System.out.println(Arrays.toString(permutation(scanner.nextLine())));
		}
		scanner.close();
	}

	public static String[] permutation(String S) {
		char[] chars = S.toCharArray();
		List<String> res = new ArrayList<>();
		backTracking(chars, 0, res);
		String[] result = new String[res.size()];
		for (int i = 0; i < res.size(); i++) {
			result[i] = res.get(i);
		}
		return result;
	}

	public static void backTracking(char[] str, int startIndex, List<String> res) {
		if (startIndex == str.length - 1) {
			res.add(new String(str));
			return;
		}
		for (int i = startIndex; i < str.length; i++) {
			swap(str, startIndex, i);
			backTracking(str, startIndex + 1, res);
			swap(str, startIndex, i);
		}
	}

	public static void swap(char[] str, int oldIndex, int newIndex) {
		char tmp = str[oldIndex];
		str[oldIndex] = str[newIndex];
		str[newIndex] = tmp;
	}

}
