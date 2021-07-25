package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3019_테트리스 {
    static int C;
    static int[] heights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = stoi(st.nextToken());
        int P = stoi(st.nextToken());
        heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int cnt = 0;

        switch (P) {
            case 1:
                cnt += check("0");
                cnt += check("0000");
                break;
            case 2:
                cnt += check("00");
                break;
            case 3:
                cnt += check("001");
                cnt += check("10");
                break;
            case 4:
                cnt += check("100");
                cnt += check("01");
                break;
            case 5:
                cnt += check("000");
                cnt += check("01");
                cnt += check("101");
                cnt += check("10");
                break;
            case 6:
                cnt += check("000");
                cnt += check("00");
                cnt += check("011");
                cnt += check("20");
                break;
            case 7:
                cnt += check("000");
                cnt += check("02");
                cnt += check("110");
                cnt += check("00");
                break;
        }

        System.out.println(cnt);
    }

    static int check(String s) {
        char[] delta = s.toCharArray();
        int cnt = 0;

        for (int i = 0; i <= C - s.length(); i++) {
            int diff = heights[i] - (delta[0] - '0');
            boolean possible = true;

            for (int j = i; j < i + delta.length; j++) {
                if (heights[j] - (delta[j - i] - '0') != diff) {
                    possible = false;
                    break;
                }
            }

            if (possible) cnt++;
        }

        return cnt;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
