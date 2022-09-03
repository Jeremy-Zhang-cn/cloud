package cn.naker.cloud.algorithms.oranges_rotting;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 994.腐烂的橘子
 *
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1
 *
 * 示例 1：
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 *
 * 示例 2：
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 *
 * 示例 3：
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 */
public class Solution {

	// 用于行列移动操作 行不变 列加减一/列不变行加减一
	static int[] rowSwift = {-1, 0, 1, 0};
	static int[] colSwift = {0, -1, 0, 1};

	public static void main(String[] args) {
//		int[][] grid = new int[][] {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//		int[][] grid = new int[][] {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
		int[][] grid = new int[][] {{0, 2}};
		System.out.println(orangesRotting(grid));
	}

	public static int orangesRotting(int[][] grid) {
		HashMap<Integer, Integer> depth = new HashMap<>();
		Queue<Integer> queue = new LinkedList<>();
		// 网格的总行列数
		int rowTotal = grid.length;
		int colTotal = grid[0].length;

		for (int r = 0; r < rowTotal; r++) {
			for (int c = 0; c < colTotal; c++) {
				if (grid[r][c] == 2) {
					// 遍历grid 初始化0层 放入所有已腐坏的记录
					int code = r * colTotal + c;
					depth.put(code, 0);
					queue.offer(code);
				}
			}
		}

		int max = 0;
		// 开始广度优先遍历
		while (!queue.isEmpty()) {
			Integer code = queue.poll();
			int r = code / colTotal;
			int c = code % colTotal;
			for (int i = 0; i < 4; i++) {
				int tr = r + rowSwift[i];
				int tc = c + colSwift[i];
				if (tr >= 0 && tr < rowTotal && tc >= 0 && tc < colTotal && grid[tr][tc] == 1) {
					grid[tr][tc] = 2;
					int tCode = tr * colTotal + tc;
					// 操作下一层 时间计数改为上一层加一
					depth.put(tCode, depth.get(code) + 1);
					queue.offer(tCode);
					max = Math.max(max, depth.get(tCode));
				}
			}
		}

		for (int[] row : grid) {
			for (int col : row) {
				if (col == 1) {
					return -1;
				}
			}
		}
		return max;
	}
}
