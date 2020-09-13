package 너비우선탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17141_연구소2 {
	static int N, M;
	static int[][] map, copymap;
	static Virus[] virus;
	static int virusCnt;
	static boolean[] select;

	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][N];
		copymap = new int[N][N];
		virus = new Virus[10];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) {
					virus[virusCnt++] = new Virus(i, j);
				}
			}
		}
		
		select = new boolean[virusCnt];
		
		ans = Integer.MAX_VALUE;
		comb(0, 0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	static void comb(int idx, int cnt) {
		if(cnt == M) {
			deepcopy();

			Queue<Virus> queue = new LinkedList<>();
			
			for(int i=0; i<virusCnt; i++) {
				Virus seed = virus[i];
				if(select[i]) {
					copymap[seed.i][seed.j] = 9;
					queue.add(seed);
				} else {
					copymap[seed.i][seed.j] = 0;
				}
			}
			
			bfs(queue);
			
			return;
		}
		
		if(idx == virusCnt) {
			return;
		}
		
		select[idx] = true;
		comb(idx + 1, cnt + 1);
		select[idx] = false;
		comb(idx + 1, cnt);
	}
	
	static void bfs(Queue<Virus> queue) {
		int time = 0;
		
		while(!queue.isEmpty()) {
			if(check()) {
				if(ans > time)
					ans = time;
				return;
			}
			
			int size = queue.size();
			for(int s=0; s<size; s++) {
				Virus now = queue.poll();
				
				for(int d=0; d<4; d++) {
					int ni = now.i + di[d];
					int nj = now.j + dj[d];
					
					if(ni<0 || ni>N-1 || nj<0 || nj>N-1) continue;
					
					if(copymap[ni][nj] == 0 || copymap[ni][nj] == 2) {
						copymap[ni][nj] = 9;
						queue.add(new Virus(ni, nj));
					}
				}
			}
			time++;
		}
	}
	
	static boolean check() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(copymap[i][j] == 0)
					return false;
			}
		}
		return true;
	}
	
	static void deepcopy() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				copymap[i][j] = map[i][j];
			}
		}
	}
	
	static class Virus {
		int i, j;

		public Virus(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
