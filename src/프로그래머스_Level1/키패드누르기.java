package 프로그래머스_Level1;

public class 키패드누르기 {
	public static String solution(int[] numbers, String hand) {
		String answer = "";
		int distance = 0;
		
		int now_left = '*';
		int now_right = '#';
		
		for (int i = 0; i < numbers.length; i++) {
			int number = numbers[i];
			if (number == 1 || number == 4 || number == 7) {
				now_left = number;
				answer += "L";
			} else if (number == 3 || number == 6 || number == 9) {
				now_right = number;
				answer += "R";
			} else {
				int distance_left = getDistance(now_left, number);
				int distance_right = getDistance(now_right, number);
				if(distance_left == distance_right) {
					if(hand.equals("left")) {
						now_left = number;
						answer += "L";
					}
					else {
						now_right = number;
						answer += "R";
					}
				} else {
					if(distance_left < distance_right) {
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
		int nr = source/3;
		int nc = source%3;
		if(nc == 0) {
			nr--;
			nc++;
		}
		int dr = destination/3;
		int dc = destination%3;
		if(dc == 0) {
			dr--;
			dc++;
		}
//		System.out.println(String.format("source : %d, destination : %d, nr : %d, nc : %d, dr : %d, dc : %d", source, destination, nr, nc, dr, dc));
		return 0;
	}

	public static void main(String[] args) {
		int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String hand = "right";

		System.out.println(solution(numbers, hand));
	}
}
