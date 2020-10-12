package 수학;

public class BOJ_15596_정수N개의합 {
	public static long sum(int[] a) {
		long answer = 0;
		for(int num : a)
			answer += num;
		return answer;
	}
}
