package cn.naker.cloud.algorithms.level_print_tree_2;

import cn.naker.cloud.algorithms.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class Solution {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		TreeNode son_l = new TreeNode(9);
		TreeNode son_r = new TreeNode(20);
		TreeNode son_r_l = new TreeNode(15);
		TreeNode son_r_r = new TreeNode(7);

		root.setLeft(son_l);
		root.setRight(son_r);
		son_r.setLeft(son_r_l);
		son_r.setRight(son_r_r);

		List<List<Integer>> list = levelOrder(root);
		for (List<Integer> level : list) {
			System.out.println(level);
		}

	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		// 利用队列的FIFO实现广度优先遍历
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<>();
		if (root != null) queue.add(root);
		while (!queue.isEmpty()) {
			ArrayList<Integer> tmp = new ArrayList<>();
			// 从队尾达到队列头 说明本层级遍历结束
			for (int i = queue.size(); i > 0; i--) {
				// 出队
				TreeNode node = queue.poll();
				if (node == null) continue;
				tmp.add(node.getData());
				// 依次向队列中加入 左、右子节点
				if (node.getLeft() != null) queue.offer(node.getLeft());
				if (node.getRight() != null) queue.offer(node.getRight());
			}
			res.add(tmp);
		}
		return res;
	}

}
