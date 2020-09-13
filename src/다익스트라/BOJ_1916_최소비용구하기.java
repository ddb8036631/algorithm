package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<Edge>[] adj = new ArrayList[N+1];
		for(int i=1; i<=N; i++)
			adj[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj[u].add(new Edge(v, c));
		}
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] used = new boolean[N+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		dist[start] = 0;
		pq.add(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(used[now.v]) continue;
			used[now.v] = true;
			
			if(now.v == dest) {
				System.out.println(now.c);
				break;
			}
			
			for(Edge next : adj[now.v]) {
				if(!used[next.v] && dist[next.v] > dist[now.v] + next.c) {
					dist[next.v] = dist[now.v] + next.c;
					pq.add(new Edge(next.v, dist[next.v]));
				}
			}
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
