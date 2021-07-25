package 완전탐색;

import java.io.*;
import java.util.Arrays;

public class BOJ_9079_동전게임 {
    static int answer = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            Character[][] map = new Character[3][3];

            for (int i = 0; i < 3; i++)
                map[i] = Arrays.stream(br.readLine().split(" ")).map(e -> e.charAt(0)).toArray(Character[]::new);

            for (int d = 0; d < 1 << 8; d++) {

            }
        }
    }
}
