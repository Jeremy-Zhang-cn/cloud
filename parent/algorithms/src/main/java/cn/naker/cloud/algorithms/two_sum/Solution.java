package cn.naker.cloud.algorithms.two_sum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数和
 *
 * 输入：[20,70,110,150], 90
 * 返回值：[1,2]
 */
public class Solution {

	public static void main(String[] args) {
		int[] nums = {110, 150, 70, 20};
		System.out.println(Arrays.toString(twoSum(nums, 90)));
	}

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[]{map.get(target - nums[i]), i + 1};
			} else {
				map.put(nums[i], i + 1);
			}
		}
		return new int[]{};
	}

}
