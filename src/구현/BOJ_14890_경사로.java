package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14890_경사로 {
	static int N, L;
	static int[][] map;
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		map = new int[N][N];

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				map[y][x] = sc.nextInt();
			}
		}

		for (int y = 0; y < N; y++) {
			int[] arr = new int[N];
			boolean[] used = new boolean[N];

			for (int i = 0; i < N; i++) {
				arr[i] = map[y][i];
			}
			solution(arr, used);
		}

		for (int x = 0; x < N; x++) {
			int[] arr = new int[N];
			boolean[] used = new boolean[N];

			for (int i = 0; i < N; i++) {
				arr[i] = map[i][x];
			}
			solution(arr, used);
		}

		System.out.println(answer);
	}

	static void solution(int[] arr, boolean[] used) {
		boolean canPass = true;

		for (int x = 1; x < N; x++) {

			// 앞에 높이가 큰 경우.
			if (arr[x - 1] > arr[x]) {
				if (arr[x - 1] - arr[x] != 1) {
					canPass = false;
					break;
				}

				else {
					int tmp = arr[x];

					// 경사로 생성.
					if (x + L - 1 <= N - 1) {
						boolean sameHeight = true;

						for (int z = x; z <= x + L - 1; z++) {
							if (used[z]) {
								canPass = false;
								break;
							}

							if (arr[z] != tmp) {
								sameHeight = false;
								break;
							}
						}

						if (!sameHeight) {
							canPass = false;
							break;
						}

						else {
							for (int z = x; z <= x + L - 1; z++) {
								used[z] = true;
							}
						}
					}

					else {
						canPass = false;
						break;
					}
				}

			}

			// 뒤 높이가 큰 경우.
			else if (arr[x - 1] < arr[x]) {
				if (arr[x] - arr[x - 1] != 1) {
					canPass = false;
					break;
				}

				else {
					int tmp = arr[x - 1];

					// 경사로 생성.
					if (x - L >= 0) {
						boolean sameHeight = true;

						for (int z = x - 1; z >= x - L; z--) {
							if (used[z]) {
								canPass = false;
								break;
							}

							if (arr[z] != tmp) {
								sameHeight = false;
								break;
							}
						}

						if (!sameHeight) {
							canPass = false;
							break;
						}

						else {
							for (int z = x - 1; z >= x - L; z--) {
								used[z] = true;
							}
						}
					}

					else {
						canPass = false;
						break;
					}
				}
			}
		}

		if (canPass) {
			answer++;
		}
	}
}
