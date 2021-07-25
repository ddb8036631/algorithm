package 문자열;

import java.io.*;

public class BOJ_4740_거울오거울 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while (!(input = br.readLine()).equals("***")) {
            bw.write(new StringBuilder(input).reverse().toString() + "\n");
        }

        bw.flush();
    }
}
