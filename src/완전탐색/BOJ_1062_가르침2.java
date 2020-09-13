package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1062_가르침2 {
	static int N;
	static int K;
	static int[] words;
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
		
		
		// 0b : binary code
		int letters = 0b10000010000100000101; // anta tica : a~t까지 선언. 꼭 배워야 하는 필수 단어
		
		words = new int[N];
		for(int i=0; i<N; i++) {
			String word = br.readLine();
			int len = word.length();
			int bword = letters;
			for(int j = 4; j < len - 4; j++) { // anta  < 중간 데이터만 bword에 세팅 > tica
				bword |= 1 << word.charAt(j) - 'a';
			}
			words[i] = bword;
//			System.out.println(Integer.toBinaryString(bword));
		}
		combi('a', 5, letters);
		System.out.println(max);
	}
	
	static void combi(int c, int cnt, int letters) {
		if(cnt == K) {
			// K개의 문자를 배웠을 때 단어를 읽을 수 있는 지 검사
			check(letters);
		}
		
		if(c > 'z') {
			return;
		}
		
		// 배우지 않았을 때
		combi(c + 1, cnt, letters);
		
		// 배웠을 때
		if((letters & (1 << c - 'a')) == 0) { // 안배운 글자니까
			combi(c + 1, cnt + 1, letters | 1 << c - 'a'); // or연산 통해 배운글자로 바꿈.
		}
	}

	static void check(int letters) {
		int count = 0;
		for(int i = 0; i < N; i++) {
			if((letters & words[i]) == words[i]) {
				count++;
			}
		}
		max = Math.max(max, count);
	}
}
