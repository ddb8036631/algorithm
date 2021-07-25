package 수학;

import java.util.Scanner;

public class BOJ_10886_0notcute1cute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cute = 0;

        for (int i = 0; i < N; i++) {
            if (sc.nextInt() == 1) {
                cute++;
            }
        }

        System.out.println(cute >= N / 2 + 1 ? "Junhee is cute!" : "Junhee is not cute!");
    }
}
