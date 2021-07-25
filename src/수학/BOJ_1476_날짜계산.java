package 수학;

import java.util.Scanner;

public class BOJ_1476_날짜계산 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();
        int year = 1;

        while (true) {
            if ((year - E) % 15 == 0 && (year - S) % 28 == 0 && (year - M) % 19 == 0) {
                System.out.println(year);
                break;
            }

            year++;
        }
    }
}
