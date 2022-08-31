package cn.naker.cloud.algorithms.hex_transfer;

import java.util.Scanner;

/**
 * 十六进制转换 输入十六进制字符串 输出对应的十进制数
 * e.g.
 * 输入0xa 输出 10
 * 输入 0xAA 输出 2748
 */
public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String str = in.nextLine();
			str2Num(str);
		}
	}

	public static void str2Num(String str) {
		char[] chars = str.toCharArray();
		int count = 0;
		// 十六进制以 0x开头 所以要从下标2开始
		for (int i = 2; i < chars.length; i++) {
			// 临时存储每一位上对应的十进制数 用于循环外累加
			int tmpNum;
			// 减去字符 'a' 转换为int值
			if (chars[i] >= 'a' && chars[i] <= 'z') {
				tmpNum = chars[i] - 'a' + 10;
			} else if (chars[i] >= 'A' && chars[i] <= 'Z') {
				tmpNum = chars[i] - 'A' + 10;
			} else {
				tmpNum = Integer.parseInt(String.valueOf(chars[i]));
			}
			/*
			 *  高位到低位一次进行 转换 相加
			 *  e.g. 0xab 高位的a对应十进制计算方式为 a代表的十进制数 10 乘上 位数
			 *     --> 从低到高第二位
			 *     --> 16^(2-1) = 16 ===> 本位对应十进制为 10 * 16^(2-1) = 160
			 */
			count += tmpNum * Math.pow(16, chars.length - i - 1);
		}
		System.out.println(count);
	}

}
