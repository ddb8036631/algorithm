package SWEA_모의SW역량테스트;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_10888_음식배달 {
	static int N;
	static int[][] map;
	static List<Point> store;
	static List<Point> house;
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			answer = Integer.MAX_VALUE;

			N = sc.nextInt();
			map = new int[N + 1][N + 1];
			store = new ArrayList<>();
			house = new ArrayList<>();

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1) {
						house.add(new Point(i, j, false));
					} else if (map[i][j] >= 2) {
						store.add(new Point(i, j, false));
					}
				}
			}

			for (int i = 1; i <= store.size(); i++) {
				comb(0, 0, i);
			}

			System.out.println("#" + tc + " " + answer);
		}
	}

	static void comb(int idx, int cnt, int max) {
		if (cnt == max) {
			calc();

			return;
		}
		if (idx == store.size())
			return;

		store.get(idx).used = true;
		comb(idx + 1, cnt + 1, max);

		store.get(idx).used = false;
		comb(idx + 1, cnt, max);

	}

	static void calc() {
		int sum = 0;
		for (Point h : house) {
			int dist = Integer.MAX_VALUE;
			for (Point s : store) {
				if (s.used) {
					dist = Math.min(dist, Math.abs(s.x - h.x) + Math.abs(s.y - h.y));
				}
			}
			sum += dist;
		}

		for (Point s : store) {
			if (s.used) {
				sum += map[s.x][s.y];
			}
		}

		answer = Math.min(answer, sum);
	}

	static class Point {
		int x, y;
		boolean used;

		public Point(int x, int y, boolean used) {
			this.x = x;
			this.y = y;
			this.used = used;
		}
	}
}
