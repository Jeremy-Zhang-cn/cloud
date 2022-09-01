package cn.naker.cloud.algorithms.binary_search;

/**
 * 二分查找
 */
public class Solution {

	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		binarySearch(arr, 7);
	}


	public static void binarySearch(int[] arr, int target) {
		int mid, low, high;
		low = 0;
		high = arr.length - 1;

		while (low <= high) {
			mid = (low + high) >>> 1;
			if (arr[mid] > target) {
				// 中值大于目标值 说明目标落在中值左侧 低位不变 高位置为原来的中值索引减一的位置
				high = mid - 1;
			} else if(arr[mid] < target) {
				// 中值小于目标值 说明目标落在中值右侧 高位不变 低位改为原来的中值索引加一位置
				low = mid + 1;
			} else {
				// 中值恰好等于目标值
				System.out.println(mid);
				return;
			}
		}
		System.out.println("target not found");
	}

}
