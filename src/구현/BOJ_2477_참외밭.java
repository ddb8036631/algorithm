package 구현;

import java.util.Scanner;

public class BOJ_2477_참외밭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int[] arr = new int[6];
		for (int i = 0; i < 6; i++) {
			sc.nextInt();
			arr[i] = sc.nextInt();
		}
		int x = Integer.MIN_VALUE;
		int y = Integer.MIN_VALUE;

		for (int i = 0; i < 6; i++) {
			// 가로
			if (i % 2 == 0) {
				x = Math.max(x, arr[i]);
			}
			// 세로
			else {
				y = Math.max(y, arr[i]);
			}
		}

		int xx = 0, yy = 0;
		for (int i = 0; i < 6; i++) {
			int sum = arr[(i + 5) % 6] + arr[(i + 1) % 6];

			// 가로
			if (i % 2 == 0) {
				if (sum == y) {
					xx = arr[i];
				}
			}

			// 세로
			else {
				if (sum == x) {
					yy = arr[i];
				}
			}
		}

		System.out.println((x * y - xx * yy) * k);
	}
}
