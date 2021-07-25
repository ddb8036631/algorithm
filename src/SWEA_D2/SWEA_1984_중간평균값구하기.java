package SWEA_D2;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1984_중간평균값구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            int[] nums = new int[10];

            for (int i = 0; i < 10; i++) {
                nums[i] = sc.nextInt();
            }

            Arrays.sort(nums);
            int sum = 0;
            for (int i = 1; i < nums.length - 1; i++) sum += nums[i];

            System.out.println("#" + tc + " " + Math.round((double) sum / 8));
        }
    }
}
