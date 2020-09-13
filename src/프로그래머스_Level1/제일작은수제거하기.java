package 프로그래머스_Level1;

import java.util.ArrayList;

public class 제일작은수제거하기 {
	public static ArrayList<Integer> solution(int[] arr) {
		ArrayList<Integer> list = new ArrayList<>();
		Integer min = Integer.MAX_VALUE;
		for (int n : arr) {
			min = Math.min(min, n);
			list.add(n);
		}
		list.remove(min);
		if (list.size() == 0)
			list.add(-1);
		return list;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 2, 1 };
//		int[] arr = { 10 };
		solution(arr);
	}
}
