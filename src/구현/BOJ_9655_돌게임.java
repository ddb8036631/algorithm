package 구현;

import java.util.Scanner;

public class BOJ_9655_돌게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(dfs(0, N >= 3 ? N - 3 : N - 1) % 2 == 0 ? "SK" : "CY");
    }

    static int dfs(int idx, int remain) {
        if (remain == 0) return idx;

        if (remain >= 3) return dfs(idx + 1, remain - 3);
        else return dfs(idx + 1, remain - 1);
    }
}
