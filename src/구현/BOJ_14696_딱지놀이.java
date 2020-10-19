package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14696_딱지놀이 {
	static int N;
	static int[] a_cnt = new int[5];
	static int[] b_cnt = new int[5];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int round = 1; round <= N; round++) {
			Arrays.fill(a_cnt, 0);
			Arrays.fill(b_cnt, 0);

			int a = sc.nextInt();
			for (int i = 0; i < a; i++) {
				a_cnt[sc.nextInt()]++;
			}
			int b = sc.nextInt();
			for (int i = 0; i < b; i++) {
				b_cnt[sc.nextInt()]++;
			}

			boolean draw = true;
			for (int i = 4; i >= 1; i--) {
				if (a_cnt[i] == b_cnt[i])
					continue;

				draw = false;
				if (a_cnt[i] > b_cnt[i]) {
					System.out.println('A');
				} else if (a_cnt[i] < b_cnt[i])
					System.out.println('B');
				break;
			}
			if (draw) {
				System.out.println('D');
			}
		}
	}
}
