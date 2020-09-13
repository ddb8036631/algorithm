package 구현;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_19238_스타트택시 {
	static int N, M, fuel;
	static int taxi_i, taxi_j;
	static List<Passenger> passengers;
	static int[][] map;
	static int[][] dist;
	static boolean[][] visit;

	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		fuel = sc.nextInt();

		map = new int[N + 1][N + 1];
		dist = new int[N + 1][N + 1];
		visit = new boolean[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1)
					dist[i][j] = N * N;
			}
		}

		taxi_i = sc.nextInt();
		taxi_j = sc.nextInt();

		passengers = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Passenger p = new Passenger(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			passengers.add(p);
		}

		boolean impossible = false;
		while (fuel > 0 && passengers.size() > 0) {
			initVisit();
			initDist();
			bfs();

			int selected = findShortestPassenger();
			if (dist[passengers.get(selected).si][passengers.get(selected).sj] == 0) {
				impossible = true;
				break;
			}

			initVisit();
			bfs(selected);
		}

		if (impossible || fuel < 0)
			System.out.println(-1);
		else
			System.out.println(fuel);
	}

	// 택시의 위치로부터 각 칸으로의 최단거리를 기록.
	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		visit[taxi_i][taxi_j] = true;
		queue.add(new Point(taxi_i, taxi_j));

		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();

				dist[now.x][now.y] = count;

				for (int d = 0; d < 4; d++) {
					int ni = now.x + di[d];
					int nj = now.y + dj[d];

					if (ni < 1 || ni > N || nj < 1 || nj > N || visit[ni][nj] || map[ni][nj] == 1)
						continue;
					visit[ni][nj] = true;
					queue.add(new Point(ni, nj));
				}
			}
			count++;
		}
	}

	// 계산된 최단거리로부터 가장 가까운 승객의 번호를 구함. 구함과 동시에 택시의 위치를 그 곳으로 이동시키고, 연료를 계산해줌.
	static int findShortestPassenger() {
		int p_num = -1;
		int min = N * N;

		for (int i = 0; i < passengers.size(); i++) {
			Passenger p = passengers.get(i);

			if (dist[p.si][p.sj] < min) {
				min = dist[p.si][p.sj];
				p_num = i;
			} else if (dist[p.si][p.sj] == min) {
				if (p.si < passengers.get(p_num).si) {
					p_num = i;
				} else if (p.si == passengers.get(p_num).si) {
					if (p.sj < passengers.get(p_num).sj) {
						p_num = i;
					}
				}
			}
		}

		taxi_i = passengers.get(p_num).si;
		taxi_j = passengers.get(p_num).sj;
		fuel -= min;

		return p_num;
	}

	// 선택된 승객의 목적지 좌표까지 택시를 이동시킴.
	static void bfs(int selected) {
		Queue<Point> queue = new LinkedList<>();
		visit[taxi_i][taxi_j] = true;
		queue.add(new Point(taxi_i, taxi_j));

		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();

				if (now.x == passengers.get(selected).di && now.y == passengers.get(selected).dj) {
					passengers.remove(selected);

					fuel -= count;
					if (fuel >= 0) {
						fuel += 2 * count;
					}

					taxi_i = now.x;
					taxi_j = now.y;

					return;
				}

				for (int d = 0; d < 4; d++) {
					int ni = now.x + di[d];
					int nj = now.y + dj[d];

					if (ni < 1 || ni > N || nj < 1 || nj > N || visit[ni][nj] || map[ni][nj] == 1)
						continue;
					visit[ni][nj] = true;
					queue.add(new Point(ni, nj));
				}
			}
			count++;
		}
	}

	static void initVisit() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				visit[i][j] = false;
			}
		}
	}

	static void initDist() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 1)
					dist[i][j] = N * N;
				else
					dist[i][j] = 0;
			}
		}
	}

	static class Passenger {
		int si;
		int sj;
		int di;
		int dj;

		public Passenger(int si, int sj, int di, int dj) {
			this.si = si;
			this.sj = sj;
			this.di = di;
			this.dj = dj;
		}

		@Override
		public String toString() {
			return "Passenger [si=" + si + ", sj=" + sj + ", di=" + di + ", dj=" + dj + "]";
		}
	}
}
