package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1269_대칭차집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        int dupCnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) set.add(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) if (set.contains(st.nextToken())) dupCnt++;

        System.out.println(a + b - 2 * dupCnt);
    }
}
