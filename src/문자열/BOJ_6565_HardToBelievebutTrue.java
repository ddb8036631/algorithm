package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6565_HardToBelievebutTrue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb = new StringBuilder();

        while (!(input = br.readLine()).equals("0+0=0")) {
            String[] s = input.split("\\+");
            String[] ss = s[1].split("=");

            StringBuilder a = new StringBuilder(s[0]).reverse();
            StringBuilder b = new StringBuilder(ss[0]).reverse();
            StringBuilder c = new StringBuilder(ss[1]).reverse();

            int aa = Integer.parseInt(a.toString());
            int bb = Integer.parseInt(b.toString());
            int cc = Integer.parseInt(c.toString());

            if (aa + bb == cc) sb.append("True");
            else sb.append("False");

            sb.append("\n");
        }

        sb.append("True");
        System.out.println(sb);
    }
}
