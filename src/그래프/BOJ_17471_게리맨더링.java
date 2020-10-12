package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	static int n;
	static int[][] adj;
	static int[] visit;
	static int[] population;
	static int total;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		adj = new int[n][n];
		visit = new int[n];
		population = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			total += population[i];
		}

		for (int from = 0; from < n; from++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int i = 0; i < cnt; i++) {
				int to = Integer.parseInt(st.nextToken()) - 1;
				adj[from][to] = 1;
				adj[to][from] = 1;
			}
		}

		for (int i = 0; i < n; i++) {
			dfs(i, 1, population[i]);
		}

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	static void dfs(int idx, int depth, int sum) {
		if(min == 0)
			return;
		if (depth == n)
			return;
		if (sum > total - sum)
			return;
		
		visit[idx] = 1;

		if (Math.abs((total - sum) - sum) < min && bfs()) {
			min = Math.min(min, Math.abs((total - sum) - sum));
		}

		for (int from = 0; from < n; from++) {
			if (visit[from] == 1) {
				for (int to = 0; to < n; to++) {
					if (adj[from][to] == 1 && visit[to] == 0)
						dfs(to, depth + 1, sum + population[to]);
				}
			}
		}

		visit[idx] = 0;
	}

	static boolean bfs() {
		Queue<Integer> queue = new LinkedList<>();
		int[] v = new int[n];
		int start = 0;

		for (int i = 0; i < n; i++) {
			v[i] = visit[i];
			if (v[i] == 0) {
				start = i;
			}
		}

		v[start] = 1;
		queue.add(start);

		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int to = 0; to < n; to++) {
				if (adj[now][to] == 1 && v[to] == 0) {
					v[to] = 1;
					queue.add(to);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (v[i] == 0)
				return false;
		}

		return true;
	}
}
