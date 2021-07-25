package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_7583_Jumbledwords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder("");
        String input;

        while (!(input = br.readLine()).equals("#")) {
            String[] words = input.split(" ");
            StringBuilder tmp = null;

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                tmp = new StringBuilder();
                tmp.append(word.charAt(0));

                for (int j = word.length() - 2; j >= 1; j--) {
                    tmp.append(word.charAt(j));
                }
                tmp.append(word.length() == 1 ? "" : word.charAt(word.length() - 1));
                answer.append(tmp);
                answer.append(" ");
            }

            answer.append("\n");
        }

        System.out.println(answer);
    }
}
