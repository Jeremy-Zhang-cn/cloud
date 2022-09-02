package cn.naker.cloud.algorithms.binary_tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 */
public class InOrder {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(4);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(6);
		TreeNode left_son_l = new TreeNode(1);
		TreeNode left_son_r = new TreeNode(3);
		TreeNode right_son_l = new TreeNode(5);
		TreeNode right_son_r = new TreeNode(7);

		root.setLeft(left);
		root.setRight(right);
		left.setLeft(left_son_l);
		left.setRight(left_son_r);
		right.setLeft(right_son_l);
		right.setRight(right_son_r);

		inOrder(root);
		System.out.println("---------");
		inOrderStack(root);
	}


	public static void inOrder(TreeNode root) {
		if (root == null) return;
		inOrder(root.getLeft());
		System.out.println("data: -> " + root.getData());
		inOrder(root.getRight());
	}

	/**
	 * 非递归方式遍历
	 */
	public static void inOrderStack(TreeNode root) {
		if (root == null) return;
		// 使用栈临时存储
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> res = new LinkedList<>();
		// 根元素不为空 -> 压入栈中 将原根元素改为其左孩子
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.getLeft();
			}
			// 栈不为空 且当前根元素为空 说明父节点再无左孩子 依次弹出当前节点 并检测其是否有右孩子 进行同样的操作
			root = stack.pop();
			res.add(root.getData());
			root = root.getRight();
		}
		for (Integer re : res) {
			System.out.println("data -> " + re);
		}
	}

}
