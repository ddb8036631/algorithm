package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6987_월드컵 {
	static int[][] gameResult;
	static int valid;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		gameResult = new int[4][18];
		
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<18; j++) {
				gameResult[i][j] = Integer.parseInt(st.nextToken());
			}
			valid = 0;
			dfs(0, 1, gameResult[i]);
			sb.append(valid + " ");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int teamA, int teamB, int[] score) {
		if(teamA > 4) {
			for(int s : score)
				if(s > 0)
					return;
			
			valid = 1;
			return;
		}
		
		if(teamB > 5) {
			dfs(teamA + 1, teamA + 2, score);
			return;
		}
		
		for(int i=0; i<3; i++) {
			if(score[teamA * 3 + i] > 0 && score[teamB * 3 + (2-i)] > 0) {
				score[teamA * 3 + i]--;
				score[teamB * 3 + (2-i)]--;
				dfs(teamA, teamB + 1, score);
				score[teamA * 3 + i]++;
				score[teamB * 3 + (2-i)]++;
			}
		}
	}
}
