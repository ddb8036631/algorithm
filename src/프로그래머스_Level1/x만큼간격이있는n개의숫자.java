package 프로그래머스_Level1;

public class x만큼간격이있는n개의숫자 {
	public static long[] solution(int x, int n) {
		long[] answer = new long[n];
		int cnt = 1;
		while (cnt <= n) {
			long tmp = Long.valueOf(x) * cnt;
			answer[cnt - 1] = tmp;
			cnt++;
		}

		return answer;
	}

	public static void main(String[] args) {
//		int x = 2;
//		int n = 5;
		int x = 4;
		int n = 3;
//		int x = -4;
//		int n = 2;
		solution(x, n);
	}
}
