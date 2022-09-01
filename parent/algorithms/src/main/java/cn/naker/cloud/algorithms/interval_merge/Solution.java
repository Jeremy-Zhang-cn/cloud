package cn.naker.cloud.algorithms.interval_merge;

import java.util.ArrayList;

/**
 * NC37 合并区间
 *
 * 给出一组区间，请合并所有重叠的区间。
 * 请保证合并后的区间按区间起点升序排列。
 *
 * e.g.
 * 输入：
 * [[10,30],[20,60],[80,100],[150,180]]
 * 返回值：
 * [[10,60],[80,100],[150,180]]

 */
public class Solution {

	public static void main(String[] args) {
		ArrayList<Interval> list = new ArrayList<>();
		Interval one = new Interval(10, 30);
		Interval three = new Interval(80, 100);
		Interval two = new Interval(20, 60);
		Interval four = new Interval(150, 180);

		list.add(one);
		list.add(two);
		list.add(three);
		list.add(four);

		System.out.println(merge(list));

	}

	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {

		/*Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.getStart() != o2.getStart()) {
					return o1.getStart() - o2.getStart();
				} else {
					return o1.getEnd() - o2.getEnd();
				}
			}
		});*/

		// 排序
		intervals.sort((o1, o2) -> {
			if (o1.getStart() != o2.getStart()) {
				return o1.getStart() - o2.getStart();
			} else {
				return o1.getEnd() - o2.getEnd();
			}
		});
		ArrayList<Interval> res = new ArrayList<>();
		// 放入首个区间
		res.add(intervals.get(0));
		int count = 0;
		// 遍历后续区间 查看是否有收尾重叠的情况
		for (int i = 1; i < intervals.size(); i++) {
			Interval target = intervals.get(i);
			Interval origin = res.get(count);
			if (target.getStart() > origin.getEnd()) {
				// 后一个区间开头大于前一个区间的结尾 说明不存在交叠现象 加入队列中 计数加一
				res.add(target);
				count++;
			} else {
				// 后一个区间的开头小于前一个区间的结尾 说明出现了交叠现象 判断后一区间是否完全包含在前一区间中
				res.remove(count);
				Interval interval = new Interval(origin.getStart(), target.getEnd());
				// 后一区间的结尾小于前一区间的结尾 说明后一区间完全包含于前一区间中 -> 仍取原来的区间值
				if (origin.getEnd() > target.getEnd()) {
					interval.setEnd(origin.getEnd());
				}
				res.add(interval);
			}
		}
		return res;
	}

}
