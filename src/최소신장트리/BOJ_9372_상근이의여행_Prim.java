package 최소신장트리;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_9372_상근이의여행_Prim {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			List<Edge>[] adj = new ArrayList[N+1];
			for(int i=1; i<=N; i++)
				adj[i] = new ArrayList<>();
			for(int i=0; i<M; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				
				adj[u].add(new Edge(v, 0));
				adj[v].add(new Edge(u, 0));
			}
			
			boolean[] used = new boolean[N+1];
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			
			int ans = -1;
			pq.add(new Edge(1, 0));
			while(!pq.isEmpty()) {
				Edge now = pq.poll();
				
				if(used[now.v]) continue;
				used[now.v] = true;
				
				for(Edge next : adj[now.v]) {
					pq.add(next);
				}
				
				if(++ans == N-1)
					break;
			}
			System.out.println(ans);
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int v, c;

		public Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}

		@Override
		public int compareTo(Edge o) {
			return this.c - o.c;
		}
	}
}
