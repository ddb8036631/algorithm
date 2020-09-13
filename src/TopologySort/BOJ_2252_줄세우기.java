package topologysort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2252_줄세우기 {
	static int N, M;
	static int[] inDegree;
	static int[] result;
	static List<Integer>[] list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		inDegree = new int[N+1];
		list = new ArrayList[N+1];
		result = new int[N+1];
		
		for(int i=1; i<=N; i++)
			list[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			list[A].add(B);
			inDegree[B]++;
		}
		
		topologySort();
		
		for(int i=1; i<=N; i++)
			System.out.print(result[i] + " ");
	}
	
	static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=N; i++)
			if(inDegree[i] == 0)
				q.add(i);
		
		for(int i=1; i<=N ;i++) {
			if(q.isEmpty())
				return;
			
			int now = q.poll();
			result[i] = now;
			
			for(int next : list[now]) {
				inDegree[next]--;
				if(inDegree[next] == 0)
					q.add(next);
			}
		}
	}
}
