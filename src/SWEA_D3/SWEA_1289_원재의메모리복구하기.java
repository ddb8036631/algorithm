package SWEA_D3;

import java.util.Scanner;

public class SWEA_1289_원재의메모리복구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            char[] arr = sc.next().toCharArray();
            int answer = arr[0] == '0' ? 0 : 1;

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != arr[i - 1]) answer++;
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
