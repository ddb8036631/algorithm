package 프로그래머스_Level2;

import java.util.Stack;

public class 주식가격 {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = prices.length - 2; i >= 0; i--) {
            int day = 0;

            while (!stack.isEmpty() && stack.peek()[0] >= prices[i])
                day += stack.pop()[1];

            answer[i] = stack.push(new int[]{prices[i], day + 1})[1];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        solution(prices);
    }
}
