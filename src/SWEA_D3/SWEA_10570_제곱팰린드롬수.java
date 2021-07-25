package SWEA_D3;

import java.util.Scanner;

public class SWEA_10570_제곱팰린드롬수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        boolean[] palindrome = new boolean[1001];

        for (int num = 1; num <= 35; num++) {
            if (isPalindrome(String.valueOf(num).toCharArray()) && isPalindrome(String.valueOf(num * num).toCharArray()))
                palindrome[num * num] = true;
        }

        for (int tc = 1; tc <= TC; tc++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int cnt = 0;

            for (int num = A; num <= B; num++) if (palindrome[num]) cnt++;

            System.out.println("#" + tc + " " + cnt);
        }
    }

    static boolean isPalindrome(char[] arr) {
        int left = arr.length / 2 - 1, right = arr.length % 2 == 0 ? arr.length / 2 : arr.length + 1;

        while (left >= 0 && right < arr.length) {
            if (arr[left] != arr[right]) return false;

            left--;
            right++;
        }

        return true;
    }
}
