package cn.naker.cloud.algorithms.longest_increment;

/**
 * LeetCode 674. 最长连续递增序列
 *
 * 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], …, nums[r - 1], nums[r]] 就是连续递增子序列。
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * 示例 2：
 *
 * 输入：nums = [2,2,2,2,2]
 * 输出：1
 */
public class Solution {

	public static void main(String[] args) {
		int[] nums = new int[] {1, 3, 5, 4, 7};
		getCount(nums);
	}

	public static void getCount(int[] nums) {
		int l = 0, r, max = 1;
		for (r = 0; r < nums.length; r++) {
			// 后一个大于前一个就继续向前取最大差值 否则将左指针重置
			if (r > 0 && nums[r] > nums[r - 1]) {
				max = Math.max(max, r - l + 1);
			} else {
				l = r;
			}
		}
		System.out.printf("count -> %d", max);
	}

}
