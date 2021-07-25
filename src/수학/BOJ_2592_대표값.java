package 수학;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2592_대표값 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] counts = new int[1000];
        int sum = 0;
        int val = 0;
        int cnt = 0;

        for (int i = 0; i < 10; i++) {
            int num = sc.nextInt();
            sum += num;
            counts[num]++;
        }

        for (int i = 0; i < 1000; i += 10) {
            if (counts[i] > cnt) {
                val = i;
                cnt = counts[i];
            }
        }

        System.out.println(sum / 10 + "\n" + val);
    }
}
