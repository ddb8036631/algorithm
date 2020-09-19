package 프로그래머스_Level1;

public class 키패드누르기 {
	public static String solution(int[] numbers, String hand) {
		String answer = "";

		int now_left = 10;
		int now_right = 12;

		for (int i = 0; i < numbers.length; i++) {
			int number = numbers[i];
			if(number == 0)
				number = 11;
			
			if (number == 1 || number == 4 || number == 7) {
				now_left = number;
				answer += "L";
			} else if (number == 3 || number == 6 || number == 9) {
				now_right = number;
				answer += "R";
			} else {
				int distance_left = getDistance(now_left, number == 0 ? 11 : number);
				int distance_right = getDistance(now_right, number == 0 ? 11 : number);
				
				if (distance_left == distance_right) {
					if (hand.equals("left")) {
						now_left = number;
						answer += "L";
					} else {
						now_right = number;
						answer += "R";
					}
				} else {
					if (distance_left < distance_right) {
						now_left = number;
						answer += "L";
					} else {
						now_right = number;
						answer += "R";
					}
				}
			}
		}

		return answer;
	}

	public static int getDistance(int source, int destination) {
		int sr = source / 3;
		int sc = source % 3;
		if (sc == 0) {
			sr--;
			sc = 3;
		}

		int dr = destination / 3;
		int dc = destination % 3;
		if (dc == 0) {
			dr--;
			dc = 3;
		}

		int distance = Math.abs(dr - sr) + Math.abs(dc - sc);
		return distance;
	}

	public static void main(String[] args) {
		int[] numbers1 = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String hand1 = "right";

		int[] numbers2 = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
		String hand2 = "left";

		int[] numbers3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		String hand3 = "right";

//		System.out.println(solution(numbers1, hand1)); // LRLLLRLLRRL
		System.out.println(solution(numbers2, hand2)); // LRLLRRLLLRR
//		System.out.println(solution(numbers3, hand3)); // LLRLLRLLRL
		
	}
}
