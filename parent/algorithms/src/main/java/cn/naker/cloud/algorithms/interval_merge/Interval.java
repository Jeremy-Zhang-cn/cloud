package cn.naker.cloud.algorithms.interval_merge;

/**
 * 区间对象
 */
public class Interval {

	private int start;
	private int end;

	public Interval() {
		this.start = 0;
		this.end = 0;
	}

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Interval{" +
				"start=" + start +
				", end=" + end +
				'}';
	}
}
