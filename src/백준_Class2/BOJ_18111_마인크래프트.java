package 백준_Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111_마인크래프트 {
	static int N, M, B;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}

		int ans_time = Integer.MAX_VALUE;
		int ans_height = 0;
		
		for (int height = min; height <= max; height++) {
			int time = 0;
			int block = B;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > height) {
						time += 2 * (map[i][j] - height);
						block += map[i][j] - height;
					} else if (map[i][j] < height) {
						time += height - map[i][j];
						block -= height - map[i][j];
					}
				}
			}

			if (block >= 0 && ans_time >= time) {
				ans_time = time;

				if (ans_height < height) {
					ans_height = height;
				}
			}
		}

		System.out.println(ans_time + " " + ans_height);
	}
}
