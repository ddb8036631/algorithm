package 자료구조;

import java.util.Scanner;

public class BOJ_11580_Footprint_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        String command = sc.next();
        boolean[][] visit = new boolean[2001][2001];

        int y = 1000, x = 1000;
        visit[y][x] = true;
        int answer = 1;

        for (int i = 0; i < L; i++) {
            switch (command.charAt(i)) {
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
                case 'S':
                    y--;
                    break;
                case 'N':
                    y++;
                    break;
            }

            if (visit[y][x]) continue;

            visit[y][x] = true;
            answer++;
        }

        System.out.println(answer);
    }
}
