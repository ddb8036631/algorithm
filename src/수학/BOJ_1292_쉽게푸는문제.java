package 수학;

import java.util.Scanner;

public class BOJ_1292_쉽게푸는문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int num = 1, idx = 1, numCnt = 0, totCnt = 0;
        int[] arr = new int[B + 1];

        while (totCnt != B) {
            arr[idx] = num;
            numCnt++;
            totCnt++;
            idx++;

            if (numCnt == num) {
                numCnt = 0;
                num++;
            }
        }

        int answer = 0;
        for (int i = A; i <= B; i++) answer += arr[i];

        System.out.println(answer);
    }
}
