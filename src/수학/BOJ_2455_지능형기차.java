package 수학;

import java.util.Scanner;

public class BOJ_2455_지능형기차 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int total = 0;
		for (int i = 0; i < 4; i++) {
			total -= sc.nextInt();
			total += sc.nextInt();
			max = Math.max(max, total);
		}
		System.out.println(max);
	}
}
