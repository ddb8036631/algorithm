package 프로그래머스_Level2;

import java.util.Arrays;
import java.util.Scanner;

public class 행렬의곱셈 {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int k = 0; k < arr2[0].length; k++) {
                int sum = 0;

                for (int j = 0; j < arr1[0].length; j++) {
                    sum += arr1[i][j] * arr2[j][k];
                }

                answer[i][k] = sum;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};
//        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
//        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        int[][] answer = solution(arr1, arr2);
        for (int i = 0; i < answer.length; i++)
            System.out.println(Arrays.toString(answer[i]));
    }
}
