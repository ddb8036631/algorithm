package 프로그래머스_Level1;

public class 평균구하기 {
	public static double solution(int[] arr) {
		double answer = 0;
		for (int num : arr)
			answer += num;

		return answer / arr.length;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
	}
}
