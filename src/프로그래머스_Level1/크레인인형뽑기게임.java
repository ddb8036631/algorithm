package 프로그래머스_Level1;

import java.util.Stack;

public class 크레인인형뽑기게임 {
	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();

		for (int idx = 0; idx < moves.length; idx++) {
			int j = moves[idx] - 1;
			int i = 0;
			while (i < board.length && board[i][j] == 0)
				i++;
			if (i == board.length)
				continue;

			if (stack.isEmpty())
				stack.push(board[i][j]);
			else {
				if (stack.peek() == board[i][j]) {
					stack.pop();
					answer += 2;
					
				} else
					stack.push(board[i][j]);
			}

			board[i][j] = 0;
		}

		return answer;
	}

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println(solution(board, moves));
	}
}
