package 문자열;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BOJ_13163_닉네임에갓붙이기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            bw.append("god");
            bw.append(Arrays.stream(br.readLine().split(" ")).skip(1).collect(Collectors.joining()) + "\n");
        }

        bw.flush();
    }
}
