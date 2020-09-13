package 프로그래머스_Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 정수내림차순으로배치하기 {
	public static long solution(long n) {
		long answer = 0;
		String s = n + "";
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i) - '0');
		}
		
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}

		});

		StringBuffer sb = new StringBuffer();
		for (Integer i : list)
			sb.append(i);
		return Long.parseLong(sb.toString());
	}

	public static void main(String[] args) {
		long n = 118372;
		solution(n);
	}
}
