package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17835_면접보는승범이네 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Edge>[] adj = new ArrayList[N+1];
		for(int i=0; i<=N; i++)
			adj[i] = new ArrayList<>();
		long[] dist = new long[N+1];
		Arrays.fill(dist, Long.MAX_VALUE-100000000);
		boolean[] used = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			adj[V].add(new Edge(U, C));
		}
	
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<K; i++) {
			int dest = Integer.parseInt(st.nextToken());
			dist[dest] = 0;
			pq.add(new Edge(dest, 0));
		}
		
		int longCity = 0;
		long longDist = 0;
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(used[now.v]) continue;
			used[now.v] = true;

			if(now.c > longDist) {
				longCity = now.v;
				longDist = now.c;
			} else if(now.c == longDist) {
				longCity = Math.min(longCity, now.v);
			}

			for(Edge next : adj[now.v]) {
				if(!used[next.v] && dist[next.v] > dist[now.v] + next.c) {
					dist[next.v] = dist[now.v] + next.c;
					pq.add(new Edge(next.v, dist[next.v]));
				}
			}
		}
		
		System.out.println(longCity);
		System.out.println(longDist);
	}
	
	static class Edge implements Comparable<Edge>{
		int v;
		long c;

		public Edge(int v, long c) {
			this.v = v;
			this.c = c;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.c, o.c);
		}
	}
}
