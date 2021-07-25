package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4072_Words {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder answer = new StringBuilder();

        while (!(input = br.readLine()).equals("#")) {
            String[] words = input.split(" ");

            for (int i = 0; i < words.length; i++) {
                String word = words[i];

                for (int j = word.length() - 1; j >= 0; j--) {
                    answer.append(word.charAt(j));
                }

                answer.append(" ");
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }
}
