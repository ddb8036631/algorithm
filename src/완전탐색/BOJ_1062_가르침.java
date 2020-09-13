package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1062_가르침 {
	static int N;
	static int K;
	static char[][] words;
	static int max;
	
	// a, c, i, n, t 5개 미리 배움.
	static boolean[] letters = {
			true, false, true,
			false, false, false,
			false, false, true,
			false, false, false,
			false, true, false,
			false, false, false,
			false, true, false,
			false, false, false,
			false, false
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		words = new char[N][];
		for(int i=0; i<N; i++) {
			words[i] = br.readLine().toCharArray();
		}
		
		combi('a', 5);
		
		System.out.println(max);
	}
	
	static void combi(int c, int cnt) {
		if(cnt == K) {
			check();
			return;
		}
		
		if(c > 'z') return;
		
		// c를 안배울 때
		combi(c+1, cnt);
		
		// c를 배울때
		int idx = c - 'a'; // 0~25 a~z
		if(!letters[idx]) {
			letters[idx] = true;
			combi(c+1, cnt+1);
			letters[idx] = false;
		}
	}
	
	static void check() {
		int count = 0;
		for(int i=0; i<N; i++) {
			boolean isRead = true;
			for(int j=0, size = words[i].length; j < size; j++) {
				int letter = words[i][j] - 'a';
				if(!letters[letter]) {
					isRead = false;
					break;
				}
			}
			
			if(isRead)
				count++;
		}
		max = Math.max(max, count);
	}
}
