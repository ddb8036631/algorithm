package 프로그래머스_Level1;

import java.util.Arrays;

public class 예산 {
	public static int solution(int[] d, int budget) {
		int answer = 0;
		int sum = 0;
		
		Arrays.sort(d);
		
		for(int i=0; i<d.length; i++) {
			sum += d[i];
			
			if(sum <= budget)
				answer++;
			else break;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int[] d1 = { 1, 3, 2, 5, 4 };
		int budget1 = 9;

		int[] d2 = {2,2,3,3};
		int budget2 = 10;
		
		System.out.println(solution(d1, budget1));
		System.out.println(solution(d2, budget2));
	}
}
