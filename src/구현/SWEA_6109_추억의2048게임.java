package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6109_추억의2048게임 {
	static int N;
	static String input;
	static int[][] map;
	static int[][] temp;
	static int dir;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			input = st.nextToken();
	
			map = new int[N][N];
			temp = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			switch(input) {
			case "up":
				dir = 2;
				break;
			case "down":
				dir = 0;
				break;
			case "left":
				dir = 3;
				break;
			case "right":
				dir = 1;
				break;
			}
			
			rotate(dir);
			
			push();
			merge();
			push();
			
			rotate(4-dir);
			
			sb.append("#"+tc+"\n");
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					sb.append(map[i][j]+" ");
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	static void push() {
		for(int i=N-2; i>=0; i--) {
			for(int j=0; j<N; j++) {
				int temp_i = i;
				while(true) {
					temp_i++;
					if(temp_i == N || map[temp_i][j]!=0) break;
					map[temp_i][j] = map[temp_i-1][j];
					map[temp_i-1][j] = 0;
				}
			}
		}
	}
	
	static void merge() {
		for(int i=N-1; i>0; i--) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == map[i-1][j]) {
					map[i][j] += map[i-1][j];
					map[i-1][j] = 0;
				}
			}
		}
	}

	static void rotate(int cnt) {
		for(int k=0; k<cnt; k++) {
			for(int i=0; i<N; i++)
				for(int j=0; j<N; j++)
					temp[i][j] = map[N-1-j][i];
			
			for(int i=0; i<N; i++)
				for(int j=0; j<N; j++)
					map[i][j] = temp[i][j];
		}
	}
}
