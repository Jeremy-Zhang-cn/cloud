package cn.naker.cloud.algorithms.least_char;

import java.util.HashMap;
import java.util.Scanner;

/**
 * HJ23 删除字符串中出现次数最少的字符
 *
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 注意每个输入文件有多组输入，即多个字符串用回车隔开
 * 数据范围：保证输入的字符串中仅出现小写字母
 * 输入描述：
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 * 输出描述：
 * 删除字符串中出现次数最少的字符后的字符串。
 * 示例1
 * 输入：
 * abcdd
 * aabcddd
 * 输出：
 * dd
 * aaddd
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			// 存储字符及其出现次数
			HashMap<Character, Integer> map = new HashMap<>();
			String str = scanner.nextLine();
			char[] chars = str.toCharArray();
			int min = 0;
			for (char c : chars) {
				if (!map.containsKey(c)) {
					// 首次出现 初始化出现次数为1  重置集合中的最小值为1
					map.put(c, 1);
					min = 1;
				} else {
					// 非首次出现 计数加1
					map.put(c, map.get(c) + 1);
				}
				// 如果map中已经不存在现在的最小值 说明目前为止所有字符出现的次数均已大于当前最小值 需要同步更新当前最小值
				if (!map.containsValue(min)) min++;
			}
			for (char c : chars) {
				if (map.get(c) != min) {
					System.out.print(c);
				}
			}
			System.out.println();
			map.clear();
		}
		scanner.close();
	}

}
