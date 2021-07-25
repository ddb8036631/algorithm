package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_19813_Dates {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            String origin = br.readLine();
            boolean isDotUsed = origin.contains(".");
            String[] splited = isDotUsed ? origin.split("\\.") : origin.split("/");

            int a = Integer.parseInt(splited[0]);
            int b = Integer.parseInt(splited[1]);
            int c = Integer.parseInt(splited[2]);

            sb.append(String.format("%02d.%02d.%04d ", isDotUsed ? a : b, isDotUsed ? b : a, c));
            sb.append(String.format("%02d/%02d/%04d\n", isDotUsed ? b : a, isDotUsed ? a : b, c));
        }

        System.out.println(sb);
    }
}
