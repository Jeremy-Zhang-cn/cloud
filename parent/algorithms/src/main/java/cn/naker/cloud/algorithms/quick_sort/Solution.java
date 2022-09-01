package cn.naker.cloud.algorithms.quick_sort;

import java.util.Arrays;

/**
 * 快排
 */
public class Solution {

	public static void main(String[] args) {
		int[] arr = new int[]{3, 1, 2, 5, 4, 6, 9, 7, 10, 8};
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr, int low, int high) {

		int key, lo, hi, tmp;
		if (low >= high) return;
		// 设置基数
		key = arr[low];
		lo = low;
		hi = high;
		while (lo < hi) {
			// 一定要先从高位开始移动
			while (key <= arr[hi] && lo < hi) {
				hi--;
			}
			while (key >= arr[lo] && lo < hi) {
				lo++;
			}
			// 内层循环调换与基数相比的两个极值位置
			if (lo < hi) {
				tmp = arr[hi];
				arr[hi] = arr[lo];
				arr[lo] = tmp;
			}
		}

		// 循环外调换基数与极值位置
		arr[low] = arr[lo];
		arr[lo] = key;

		quickSort(arr, low, hi - 1);
		quickSort(arr, hi + 1, high);

	}

}
