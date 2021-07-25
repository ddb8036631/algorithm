package 문자열;

import java.util.Scanner;

public class BOJ_15184_LetterCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String input = sc.nextLine();
        int[] cnt = new int[26];

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                cnt[input.charAt(i) - 'a']++;
            } else if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                cnt[input.charAt(i) - 'A']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            sb.append((char) (i + 'A') + " | ");

            for (int j = 0; j < cnt[i]; j++) {
                sb.append('*');
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
