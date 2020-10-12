package 구현;

import java.util.Scanner;

public class BOJ_5622_다이얼 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		String[] strs = { "", "", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			for (int j = 3; j < strs.length; j++) {
				if (strs[j].contains(c + "")) {
					sum += j;
					break;
				}
			}
		}
		System.out.println(sum);
	}
}
