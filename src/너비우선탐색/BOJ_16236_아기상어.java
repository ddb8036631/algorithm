package 너비우선탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16236_아기상어 {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int shark_i, shark_j;
	static ArrayList<Fish> fishes = new ArrayList<>();
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int sharkSize = 2;
	static int ans;
	static final int INF = 987654321;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int size = sc.nextInt();
				map[i][j] = size;
				if(size == 9) {
					shark_i = i;
					shark_j = j;
					map[i][j] = 0;
				} else if(size != 0) {
					fishes.add(new Fish(i, j, size, 0));
				}
			}
		}
		
		int eatCnt = 0;
		while(true) {
			if(fishes.size() == 0) break;
			
			calDist();

			int eatableFishCnt = 0;
			for(Fish fish : fishes) {
				if(fish.dist != INF && fish.size < sharkSize)
					eatableFishCnt++;
			}
			
			if(eatableFishCnt == 0) break;
			
			Fish fish = null;
			for(int i=0; i<fishes.size(); i++) {
				if(fishes.get(i).size < sharkSize) {
					fish = fishes.get(i);
					fishes.remove(fish);
					break;
				}
			}
			
			map[fish.i][fish.j] = 0; 
			ans += fish.dist;
			shark_i = fish.i;
			shark_j = fish.j;
			
			eatCnt++;

			if(eatCnt == sharkSize) {
				sharkSize++;
				eatCnt = 0;
			}
		}
		
		System.out.println(ans);
	}
	
	static void calDist() {
		for(Fish fish : fishes) {
			fish.dist = bfs(fish);
		}
		
		Collections.sort(fishes);
	}
	
	static int bfs(Fish fish) {
		for(boolean[] row : visit)
			Arrays.fill(row, false);
		
		Queue<Shark> queue = new LinkedList<>();
		visit[shark_i][shark_j] = true;
		map[shark_i][shark_j] = 0;
		queue.add(new Shark(shark_i, shark_j, 0));

		while(!queue.isEmpty()) {
			Shark now = queue.poll();
		
			if(now.i == fish.i && now.j == fish.j) {
				return now.cnt;
			}
			
			for(int d=0; d<4; d++) {
				int ni = now.i + di[d];
				int nj = now.j + dj[d];
				
				if(ni<0 || ni>N-1 || nj<0 || nj>N-1 || visit[ni][nj] || map[ni][nj] > sharkSize) continue;

				visit[ni][nj] = true;
				queue.add(new Shark(ni, nj, now.cnt+1));
			}
		}
		return INF;
	}
	
	static class Fish implements Comparable<Fish> {
		int i, j, size, dist;

		public Fish(int i, int j, int size, int dist) {
			this.i = i;
			this.j = j;
			this.size = size;
			this.dist = dist;
		}

		@Override
		public int compareTo(Fish o) {
			if(this.dist != o.dist) {
				return this.dist - o.dist;
			} else if(this.i != o.i) {
				return this.i - o.i;
			} else if(this.j != o.j) {
				return this.j - o.j;
			} else
				return this.size - o.size;
		}
	}
	
	static class Shark {
		int i, j, cnt;

		public Shark(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}
}
