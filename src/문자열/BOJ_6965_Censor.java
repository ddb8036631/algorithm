package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6965_Censor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            String[] words = br.readLine().split(" ");

            for (int i = 0; i < words.length; i++) {
                String word = words[i];

                if (word.length() == 4) {
                    sb.append("**** ");
                } else {
                    sb.append(word);
                    sb.append(" ");
                }
            }

            sb.append("\n\n");
        }

        System.out.println(sb);
    }
}
