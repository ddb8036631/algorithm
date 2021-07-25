package 문자열;

import java.io.*;

public class BOJ_12605_단어순서뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String[] inputs = br.readLine().split(" ");
            bw.append("Case #" + i + ": ");
            for (int j = inputs.length - 1; j >= 0; j--) bw.append(inputs[j] + " ");
            bw.append("\n");
        }

        bw.flush();
    }
}
