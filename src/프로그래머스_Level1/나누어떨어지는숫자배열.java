package 프로그래머스_Level1;

import java.util.ArrayList;
import java.util.Collections;

public class 나누어떨어지는숫자배열 {
	public static ArrayList<Integer> solution(int[] arr, int divisor) {
		ArrayList<Integer> answer = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				answer.add(arr[i]);
			}
		}

		Collections.sort(answer);

		if (answer.size() == 0) {
			answer.add(-1);
		}
		return answer;
	}

	public static void main(String[] args) {
//		int[] arr = { 5, 9, 7, 10 };
//		int divisor = 5;
		int[] arr = { 2, 36, 1, 3 };
		int divisor = 1;
//		int[] arr = { 3, 2, 6 };
//		int divisor = 10;
		ArrayList<Integer> answer = solution(arr, divisor);
		for (int a : answer)
			System.out.println(a);

	}
}
