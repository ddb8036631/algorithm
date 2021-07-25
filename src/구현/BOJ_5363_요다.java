package 구현;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BOJ_5363_요다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringBuilder sb = new StringBuilder();
            String[] splited = br.readLine().split(" ");
            sb.append(Arrays.stream(splited).skip(2).collect(Collectors.joining(" ")));
            sb.append(" " + splited[0] + " " + splited[1] + "\n");
            bw.write(sb.toString());
        }

        bw.flush();
    }
}
