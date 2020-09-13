package 프로그래머스_Level1;

import java.util.ArrayList;

public class 자연수뒤집어배열로만들기 {
	public static ArrayList<Integer> solution(long n) {
		ArrayList<Integer> answer = new ArrayList<>();
		String s = n + "";
		StringBuffer sb = new StringBuffer(s);
		sb = sb.reverse();
		System.out.println(sb);
		for (int i = 0; i < sb.length(); i++) {
			answer.add(sb.charAt(i) - '0');
		}
		return answer;
	}

	public static void main(String[] args) {
		long n = 12345;
		solution(n);

	}
}
