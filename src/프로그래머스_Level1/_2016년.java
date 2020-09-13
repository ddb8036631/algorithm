package 프로그래머스_Level1;

public class _2016년 {
	public static String solution(int a, int b) {
		String answer = "";
		String[] w = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
		int m[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int total = 0;
		for (int i = 0; i < a - 1; i++) {
			total += m[i];
		}

		total += b - 1;
		answer = w[total % 7];

		return answer;
	}

	public static void main(String[] args) {
		int a = 5;
		int b = 24;
		solution(a, b);
	}
}
