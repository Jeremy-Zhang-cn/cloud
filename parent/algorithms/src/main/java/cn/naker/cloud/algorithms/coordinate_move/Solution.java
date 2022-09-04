package cn.naker.cloud.algorithms.coordinate_move;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * HJ17 坐标移动
 *
 * 描述
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 *
 * 输入：
 *
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 *
 * 坐标之间以;分隔。
 *
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 *
 * 下面是一个简单的例子 如：
 *
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 *
 * 处理过程：
 *
 * 起点（0,0）
 *
 * +   A10   =  （-10,0）
 *
 * +   S20   =  (-10,-20)
 *
 * +   W10  =  (-10,-10)
 *
 * +   D30  =  (20,-10)
 *
 * +   x    =  无效
 *
 * +   A1A   =  无效
 *
 * +   B10A11   =  无效
 *
 * +  一个空 不影响
 *
 * +   A10  =  (10,-10)
 *
 * 结果 （10， -10）
 *
 * 输入描述：
 * 一行字符串
 *
 * 输出描述：
 * 最终坐标，以逗号分隔
 *
 * 示例1
 * 输入：
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 输出：
 * 10,-10
 * 示例2
 * 输入：
 * ABC;AKL;DA1;
 * 输出：
 * 0,0
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			getResult(scanner.nextLine());
		}
		scanner.close();
	}

	public static void getResult(String str) {
		int[] res = new int[]{0, 0};
		String[] split = str.split(";");
		for (String s : split) {
			if (s.startsWith("A")) {
				String substring = s.substring(1);
				if (isNumeric(substring)) {
					res[0] -= Integer.parseInt(substring);
				}
			} else if (s.startsWith("D")) {
				String substring = s.substring(1);
				if (isNumeric(substring)) {
					res[0] += Integer.parseInt(substring);
				}
			} else if (s.startsWith("W")) {
				String substring = s.substring(1);
				if (isNumeric(substring)) {
					res[1] += Integer.parseInt(substring);
				}
			} else if (s.startsWith("S")) {
				String substring = s.substring(1);
				if (isNumeric(substring)) {
					res[1] -= Integer.parseInt(substring);
				}
			}
		}
		System.out.printf("%d,%d", res[0], res[1]);
	}

	public static boolean isNumeric(String s) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(s).matches();
	}

}
