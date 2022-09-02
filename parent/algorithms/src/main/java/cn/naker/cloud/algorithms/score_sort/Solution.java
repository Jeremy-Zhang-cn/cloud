package cn.naker.cloud.algorithms.score_sort;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * HJ68.成绩排序
 *
 * 给定一些同学的信息（名字，成绩）序列，请你将他们的信息按照成绩从高到低或从低到高的排列,相同成绩都按先录入排列在前的规则处理。
 * 注：0代表从高到低，1代表从低到高
 *
 * 输入描述：
 * 第一行输入要排序的人的个数n，第二行输入一个整数表示排序的方式，之后n行分别输入他们的名字和成绩，以一个空格隔开
 *
 * 输出描述：
 * 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
 *
 * 示例
 * 输入：
 * 3
 * 0
 * fang 90
 * yang 50
 * ning 70
 * 输出：
 * fang 90
 * ning 70
 * yang 50
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Student> list = new ArrayList<>();
		while (scanner.hasNext()) {
			int m = Integer.parseInt(scanner.nextLine());
			int flag = Integer.parseInt(scanner.nextLine());
			if (m > 0) {
				for (int i = 0; i < m; i++) {
					String s = scanner.nextLine();
					String[] split = s.split(" ");
					Student student = new Student();
					student.setName(split[0]);
					student.setScore(Integer.parseInt(split[1]));
					list.add(student);
				}
				list.sort((o1, o2) -> {
					if (flag == 1) {
						return o1.getScore() - o2.getScore();
					} else {
						return o2.getScore() - o1.getScore();
					}
				});
			}
			for (Student student : list) {
				System.out.printf("%s %d\n", student.getName(), student.getScore());
			}
		}
		scanner.close();
	}


	public static class Student {
		private String name;
		private Integer score;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getScore() {
			return score;
		}

		public void setScore(Integer score) {
			this.score = score;
		}

		@Override
		public String toString() {
			return "Student{" +
					"name='" + name + '\'' +
					", score=" + score +
					'}';
		}
	}

}
