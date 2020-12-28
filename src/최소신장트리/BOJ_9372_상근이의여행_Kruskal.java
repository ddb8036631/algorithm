package 최소신장트리;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BOJ_9372_상근이의여행_Kruskal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			List<Edge> adj = new ArrayList<>();
			int[] parent = new int[N+1];
			for(int i=1; i<=N; i++)
				parent[i] = i;
			for(int i=0; i<M; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				
				adj.add(new Edge(u, v, 0));
				adj.add(new Edge(v, u, 0));
			}
			
			adj.sort(new Comparator<Edge>() {
				@Override
				public int compare(Edge o1, Edge o2) {
					return o1.c - o2.c;
				}
			});
			
			int ans = 0;
			for(Edge e : adj) {
				if(find(parent, e.u) != find(parent, e.v)) {
					ans++;
					union(parent, e.u, e.v);
				}
			}
			System.out.println(ans);
		}
	}
	
	static int find(int[] parent, int v) {
		if(parent[v] == v)
			return v;
		else
			return parent[v]=find(parent, parent[v]);
	}
	
	static void union(int[] parent, int v1, int v2) {
		v1 = find(parent, v1);
		v2 = find(parent, v2);
		
		parent[v2] = v1;
	}
	
	static class Edge {
		int u, v, c;

		public Edge(int u, int v, int c) {
			this.u = u;
			this.v = v;
			this.c = c;
		}
	}
}
