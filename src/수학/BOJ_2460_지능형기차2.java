package 수학;

import java.util.Scanner;

public class BOJ_2460_지능형기차2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum -= sc.nextInt();
			sum += sc.nextInt();
			max = Math.max(max, sum);
		}

		System.out.println(max);
	}
}
