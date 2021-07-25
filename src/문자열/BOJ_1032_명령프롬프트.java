package 문자열;

import java.util.Scanner;

public class BOJ_1032_명령프롬프트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] filenames = new String[N];

        for (int i = 0; i < N; i++) filenames[i] = sc.nextLine();

        char[] result = filenames[0].toCharArray();

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < filenames[i].length(); j++) {
                if (result[j] == '?') continue;
                if (result[j] == filenames[i].charAt(j)) continue;

                result[j] = '?';
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }
}
