package SWEA_D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1948_날짜계산기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine().trim());
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int tc = 1; tc <= TC; tc++) {
            String[] splited = br.readLine().split(" ");
            int m1 = Integer.parseInt(splited[0]);
            int d1 = Integer.parseInt(splited[1]);
            int m2 = Integer.parseInt(splited[2]);
            int d2 = Integer.parseInt(splited[3]);
            int sum = 0;

            for (int m = m1; m < m2; m++) {
                sum += days[m];
            }

            System.out.println("#" + tc + " " + (sum + d2 - d1 + 1));
        }
    }
}
