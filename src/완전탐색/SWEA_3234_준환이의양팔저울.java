package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3234_준환이의양팔저울 {
	static int N;
	static int[] weight;
	static boolean[] used;
	static int sum;
	static int ans;
	static int[] exponential = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512 };
	static int[] factorial = { 0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			weight = new int[N];
			used = new boolean[N];

			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
				sum += weight[i];
			}
			
			ans = 0;
			perm(0, 0, 0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static void perm(int idx, int leftSum, int rightSum) {
		if(idx == N) {
			ans++;
			
			return;
		}
		
		if(leftSum >= sum - leftSum) {
			ans += exponential[N - idx] * factorial[N - idx];
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!used[i]) {
				used[i] = true;
				
				perm(idx + 1, leftSum + weight[i] , rightSum);
				if(leftSum >= rightSum + weight[i])
					perm(idx + 1, leftSum, rightSum + weight[i]);
				
				used[i] = false;
			}
		}
	}
}
