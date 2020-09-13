package simulation;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_19236_청소년상어 {

	// 1번 인덱스부터, 상 -> 좌상 -> 좌 -> 좌하 -> 하 -> 우하 -> 우 -> 우상 : 8방
	static int[] di = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dj = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[][] map = new int[4][4];

	static Fish[] fishes = new Fish[17]; // 번호가 1부터 16까지인 물고기
	static boolean[] isAlive = new boolean[17];

	static int ans;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int num = sc.nextInt(); // 물고기의 번호
				int dir = sc.nextInt(); // 물고기의 방향

				fishes[num] = new Fish(i, j, dir); // 1번 물고기부터 배열에 저장됨.
				map[i][j] = num; // map에 물고기의 번호를 저장함.
			}
		}

		Arrays.fill(isAlive, true);

		int fishNum = map[0][0];
		int sharkDir = fishes[fishNum].d;
		map[0][0] = -1; // 상어에 먹힘을 표시.
		isAlive[fishNum] = false;

		dfs(0, 0, sharkDir, fishNum);

		System.out.println(ans);

	}

	public static void dfs(int r, int c, int dir, int sum) {
		ans = Math.max(ans, sum);

		int[][] copyMap = new int[4][4];
		Fish[] copyFishes = new Fish[17];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				copyMap[i][j] = map[i][j];
			}
		}

		for (int i = 1; i <= 16; i++)
			copyFishes[i] = fishes[i];

		move(); // 물고기 이동

		// 상어가 갈 수 있는 모든 곳 가보기.
		for (int i = 1; i <= 3; i++) {
			int nr = r + di[dir] * i;
			int nc = c + dj[dir] * i;

			if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4) {
				if (map[nr][nc] == 0)
					continue; // 다음 위치가 이미 먹힌 곳이라면 continue

				map[r][c] = 0; // 현재 위치를 0 표시.
				int num = map[nr][nc]; // 다음 물고기의 번호를 num에 저장.
				map[nr][nc] = -1; // 다음 위치를 상어가 먹힌 곳임을 표시
				isAlive[num] = false; // num은 먹혔음을 표시.

				dfs(nr, nc, fishes[num].d, sum + num);

				// dfs를 돌아와서는 원상복귀.
				isAlive[num] = true;
				map[nr][nc] = num;
				map[r][c] = -1;
			} else {
				break; // 범위밖에 있으면 break;
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				map[i][j] = copyMap[i][j];
			}
		}

		for (int i = 1; i <= 16; i++)
			fishes[i] = copyFishes[i];
	}

	public static void move() {
		// 물고기 이동
		for (int idx = 1; idx <= 16; idx++) {
			if (!isAlive[idx])
				continue; // 물고기 죽었으면 안움직이기.

			Fish cur = fishes[idx];
			int ni = cur.x;
			int nj = cur.y;
			int nd = cur.d;
			boolean exitFlag = false;

			int[] changeDir = { 0, 2, 3, 4, 5, 6, 7, 8, 1 }; // 반시계 방향 바꾸기용 배열

			// 8방향 시도
			for (int i = 0; i < 8; i++) {
				ni = cur.x + di[nd];
				nj = cur.y + dj[nd];

				if (ni >= 0 && ni < 4 && nj >= 0 && nj < 4) {
					// 상어가 있는 곳이면 방향 바꿈.
					if (map[ni][nj] == -1) {
						nd = changeDir[nd];
						continue;
					} else {
						exitFlag = true;
						break;
					}
				} else {
					nd = changeDir[nd];
				}
			}

			if (!exitFlag)
				continue; // 움직일 수 없는 물고기니 다음 물고기 판단.

			int tempNum = map[ni][nj];
			map[ni][nj] = map[cur.x][cur.y];
			map[cur.x][cur.y] = tempNum;

			fishes[idx] = new Fish(ni, nj, nd);
			if (tempNum != 0)
				fishes[tempNum] = new Fish(cur.x, cur.y, fishes[tempNum].d);
		}
	}

	public static class Fish {
		int x, y, d;

		public Fish(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
