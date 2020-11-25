package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18870_좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        int[] X = new int[N];
        List<Pair> list = new ArrayList<>();
        int[] ans = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
            list.add(new Pair(X[i], i));
        }

        Collections.sort(list);

        int pivot = list.get(0).value;
        int count = 0;
        for (int i = 1; i < N; i++) {
            int value = list.get(i).value;
            int index = list.get(i).index;

            if (value == pivot) {
                ans[index] = count;
                pivot = value;
            } else {
                ans[index] = ++count;
                pivot = value;
            }
        }

        for (int num : ans) {
            sb.append(num + " ");
        }
        System.out.println(sb);
    }

    private static class Pair implements Comparable<Pair> {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair p) {
            return this.value - p.value;
        }
    }
}
