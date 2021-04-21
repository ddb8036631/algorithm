package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11575_AffineCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        int a, b;
        String s;
        StringBuilder answer = new StringBuilder();

        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                answer.append((char) ((a * (s.charAt(j) - 'A') + b) % 26 + 'A'));
            }

            answer.append("\n");
        }

        System.out.println(answer);
    }
}
