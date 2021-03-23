package 구현;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_14719_빗물 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int[] heights = new int[W];
        int answer = 0;

        for (int i = 0; i < W; i++) heights[i] = sc.nextInt();

        for (int i = 1; i < W; i++) {
            int left = heights[i], right = heights[i];

            for (int j = 0; j < i; j++) left = Math.max(left, heights[j]);
            for (int j = i + 1; j < W; j++) right = Math.max(right, heights[j]);

            int min = Math.min(left, right);
            answer += min - heights[i];
        }

        System.out.println(answer);
    }
}
