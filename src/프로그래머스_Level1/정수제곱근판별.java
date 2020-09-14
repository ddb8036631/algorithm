package 프로그래머스_Level1;

public class 정수제곱근판별 {
	public static long solution(long n) {
		long answer = 0;

		long sqrt = (int) Math.sqrt(n);
		if (sqrt * sqrt == n) {
			answer = (sqrt + 1) * (sqrt + 1);
		} else
			answer = -1;

		return answer;
	}

	public static void main(String[] args) {
		long n = 3;
		solution(n);
	}
}
