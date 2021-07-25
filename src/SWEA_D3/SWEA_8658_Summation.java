package SWEA_D3;

import java.util.Scanner;

public class SWEA_8658_Summation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            int[] nums = new int[10];
            int max = 0, min = Integer.MAX_VALUE;

            for (int i = 0; i < 10; i++) nums[i] = sc.nextInt();

            for (int i = 0; i < 10; i++) {
                char[] tmp = String.valueOf(nums[i]).toCharArray();
                int sum = 0;

                for (int j = 0; j < tmp.length; j++) sum += tmp[j] - '0';

                max = Math.max(max, sum);
                min = Math.min(min, sum);
            }

            System.out.println("#" + tc + " " + max + " " + min);
        }
    }
}
