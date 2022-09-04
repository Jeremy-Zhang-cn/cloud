package cn.naker.cloud.algorithms.combination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * LeetCode 77. 组合
 *
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String nums = scanner.nextLine();
			String[] s = nums.split(" ");
			System.out.println(combine(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
		}
		scanner.close();
	}

	public static List<List<Integer>> combine(int n, int k) {
		List<Integer> path = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		backTracking(n, k, 1, path, res);
		return res;
	}


	public static void backTracking(int n, int k, int startIndex, List<Integer> path, List<List<Integer>> res) {
		// 回溯法暴力穷举求解
		if (path.size() == k) {
			// 递归终止条件为路径长度符合k 收集本次符合要求的结果 终止递归
			res.add(new ArrayList<>(path));
			return;
		}

		// 因为是求组合 所以不存在顺序问题 每个数字只能取一次 使用startIndex标注当前横向位置
		// 剪枝： 搜索起点的上界 + 接下来要选择的元素个数 - 1 = n -> 搜索起点的上界 = n - (k - path.size()) + 1
		for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
			path.add(i);
			// 递归 求下一位
			backTracking(n, k, i + 1, path, res);
			// 回溯 撤销上一步的操作 查看另外的解
			path.remove(path.size() - 1);
		}

	}

}
