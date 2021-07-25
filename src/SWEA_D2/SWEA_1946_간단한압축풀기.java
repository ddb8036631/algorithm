package SWEA_D2;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1946_간단한압축풀기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= TC; tc++) {
            int N = sc.nextInt();
            sc.nextLine();
            int cnt = 0;

            sb.append("#" + tc + "\n");

            for (int i = 0; i < N; i++) {
                String[] splited = sc.nextLine().split(" ");

                for (int j = 0; j < Integer.parseInt(splited[1]); j++) {
                    sb.append(splited[0]);

                    if (++cnt % 10 == 0) sb.append("\n");
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
