package cn.naker.cloud.algorithms.binary_tree;

/**
 * 中序遍历
 */
public class InOrder {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(4);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(7);
		TreeNode left_son = new TreeNode(2);
		TreeNode right_son = new TreeNode(5);

		root.setLeft(left);
		root.setRight(right);
		left.setRight(left_son);
		right.setLeft(right_son);

		inOrder(root);
	}


	public static void inOrder(TreeNode root) {
		if (root == null) return;
		inOrder(root.getLeft());
		System.out.println("data: -> " + root.getData());
		inOrder(root.getRight());
	}

}
