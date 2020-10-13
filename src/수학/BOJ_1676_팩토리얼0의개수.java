package 수학;

import java.util.Scanner;

public class BOJ_1676_팩토리얼0의개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int two = 0;
		int five = 0;
		for (int i = 1; i <= N; i++) {
			int temp = i;
			while ((temp % 5) == 0) {
				five++;
				temp /= 5;
			}
			while ((temp % 2) == 0) {
				two++;
				temp /= 2;
			}

		}
		System.out.println(((two < five) ? two : five));
	}
}
