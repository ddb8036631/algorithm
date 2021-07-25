package 모의테스트;

import java.util.Scanner;

public class BOJ_1072_게임_이분탐색 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int Z = getPercent(X, Y);
        int low = 0, high = (int) 1e9;
        int answer = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (getPercent(X + mid, Y + mid) != Z) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static int getPercent(int X, int Y) {
        return (int) ((long) 100 * Y / X);
    }
}
