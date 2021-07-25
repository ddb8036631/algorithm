package SWEA_D3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225_암호생성기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            int tc = sc.nextInt();
            Queue<Integer> q = new LinkedList<>();

            for (int j = 0; j < 8; j++) q.add(sc.nextInt());

            boolean exit = false;

            outer:
            while (true) {
                for (int num = 1; num <= 5; num++) {
                    int now = q.poll();
                    now -= num;

                    if (now <= 0) {
                        exit = true;
                        now = 0;
                    }

                    q.add(now);

                    if (exit) break outer;
                }
            }

            System.out.print("#" + tc + " ");
            while (!q.isEmpty()) System.out.print(q.poll() + " ");
            System.out.println();
        }
    }
}
