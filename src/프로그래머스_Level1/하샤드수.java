package 프로그래머스_Level1;

public class 하샤드수 {
	public static boolean solution(int x) {
		boolean answer = true;
		int tmp = x;
		int sum = 0;
		while (tmp != 0) {
			sum += tmp % 10;
			tmp = tmp / 10;
		}

		if (x % sum == 0)
			answer = true;
		else
			answer = false;
		return answer;
	}

	public static void main(String[] args) {
		int x = 11;
		System.out.println(solution(x));
	}
}
