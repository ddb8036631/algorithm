package 카카오2019_겨울인턴십;

import java.util.Stack;

public class 크레인인형뽑기게임 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            int i = 0;

            while (i < board.length && board[i][move - 1] == 0) i++;

            if (i == board.length) continue;

            if (!stack.isEmpty() && stack.peek() == board[i][move - 1]) {
                stack.pop();
                answer += 2;
            } else stack.push(board[i][move - 1]);

            board[i][move - 1] = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4});
    }
}
