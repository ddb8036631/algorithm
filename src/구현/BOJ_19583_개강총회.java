package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_19583_개강총회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = calTime(st.nextToken());
        int E = calTime(st.nextToken());
        int Q = calTime(st.nextToken());
        HashSet<String> enter = new HashSet<>();
        int answer = 0;
        String input = null;

        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            int time = calTime(st.nextToken());
            String name = st.nextToken();

            if (time <= S) {
                enter.add(name);
                continue;
            }

            if (E <= time && time <= Q && enter.contains(name)) {
                answer++;
                enter.remove(name);
            }
        }

        System.out.println(answer);
    }

    static int calTime(String str) {
        String[] splited = str.split(":");
        int hour = Integer.parseInt(splited[0]);
        int min = Integer.parseInt(splited[1]);

        return hour * 60 + min;
    }
}
