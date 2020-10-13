package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_17779_게리맨더링2 {
	static int N;
	static int[][] map;
	static int[] region;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		region = new int[6];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int d1 = 1; d1 <= N; d1++) {
			for (int d2 = 1; d2 <= N; d2++) {
				// 1 ≤ x < x+d1+d2 ≤ N
				for (int x = 1; x < x + d1 + d2 && x + d1 + d2 <= N; x++) {
					// 1 ≤ y-d1 < y < y+d2 ≤ N
					for (int y = 1; y > y - d1 && y < y + d2 && y + d2 <= N; y++) {
						make(x, y, d1, d2);
					}
				}
			}
		}

		System.out.println(answer);
	}

	static void make(int x, int y, int d1, int d2) {
		Arrays.fill(region, 0);

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				// 1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
				if (r >= 1 && r < x + d1 && c >= 1 && c <= y) {
					region[1] += map[r][c];
				}

				// 2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
				else if (1 <= r && r <= x + d2 && y < c && c <= N) {
					region[2] += map[r][c];
				}

				// 3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
				else if (x + d1 <= r && r <= N && 1 <= c && c < y - d1 + d2) {
					region[3] += map[r][c];
				}

				// 4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
				else if (x + d2 < r && r <= N && y - d1 + d2 <= c && c <= N) {
					region[4] += map[r][c];
				}

				// 5번 선거구: 나머지
				else {
					region[5] += map[r][c];
				}
			}
		}

		int max = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= 5; i++) {
			System.out.println(i + "번 구역 : " + region[i]);
			max = Math.max(max, region[i]);
			min = Math.min(min, region[i]);
		}

		answer = Math.min(answer, max - min);
	}
}
