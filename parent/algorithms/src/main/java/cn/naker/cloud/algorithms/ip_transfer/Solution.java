package cn.naker.cloud.algorithms.ip_transfer;

import java.util.Scanner;

/**
 * HJ33 整数与IP地址间的转换
 * 描述
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 * <p>
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 * <p>
 * 数据范围：保证输入的是合法的 IP 序列
 * <p>
 * 输入描述：
 * 输入
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 * <p>
 * 输出描述：
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 * <p>
 * e.g.
 * 输入：
 * 10.0.3.193
 * 167969729
 * 复制
 * 输出：
 * 167773121
 * 10.3.3.193
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			transfer(scanner.nextLine());
		}
		scanner.close();
	}

	public static void transfer(String str) {
		if (str.contains(".")) {
			// ip转二进制
			StringBuilder sb = new StringBuilder();
			String[] nums = str.split("\\.");
			for (String num : nums) {
				StringBuilder s = new StringBuilder(Integer.toBinaryString(Integer.parseInt(num)));
				while (s.length() < 8) {
					s.insert(0, "0");
				}
				sb.append(s.toString());
			}
			System.out.println(Long.parseLong(sb.toString(), 2));

		} else {
			// 十进制转ip
			String[] nums = new String[4];
			StringBuilder binaryStr = new StringBuilder(Long.toBinaryString(Long.parseLong(str)));
			while (binaryStr.length() < 32) {
				binaryStr.insert(0, "0");
			}
			String s = binaryStr.toString();
			// 定长 4段
			for (int i = 0; i < 4; i++) {
				String substring = s.substring(8 * i, (8 * i) + 8);
				nums[i] = Integer.toString(Integer.parseInt(substring, 2));
			}
			System.out.println(String.join(".", nums));
		}
	}

}
