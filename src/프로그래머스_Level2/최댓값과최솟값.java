package 프로그래머스_Level2;

import java.util.Arrays;
import java.util.Scanner;

public class 최댓값과최솟값 {
	public static String solution(String s) {
		String answer = "";
		String[] strs = s.split(" ");
		int[] arr = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}

		Arrays.sort(arr);

		answer = arr[0] + " " + arr[strs.length - 1];

		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		solution(s);
	}
}
