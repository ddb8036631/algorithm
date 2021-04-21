package 모의테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20440_니가싫어싫어너무싫어싫어오지마내게찝쩍대지마 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Pair[] pairs = new Pair[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int Te = Integer.parseInt(st.nextToken());
            int Tx = Integer.parseInt(st.nextToken());

            pairs[i] = new Pair(Te, Tx, 1);
        }

        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p1.start, p2.start);
            }
        });

        Arrays.sort(pairs, (p1, p2) -> Integer.compare(p1.start, p2.start));
        Arrays.sort(pairs, (p1, p2) -> p1.start - p2.start);
        Arrays.sort(pairs, Comparator.comparingInt(p -> p.start));

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.end, o2.end);
            }
        });

        int maxCnt = 0, Tem = 0, Txm = 0;

        for (Pair p : pairs) {
            while (!pq.isEmpty() && p.start >= pq.peek().end) pq.poll();

            pq.add(p);

            if (pq.size() > maxCnt) {
                maxCnt = pq.size();
                Tem = p.start;
                Txm = pq.peek().end;
            } else if (pq.size() == maxCnt && Txm == p.start) {
                Txm = p.end;
            }
        }

        System.out.println(maxCnt + "\n" + Tem + " " + Txm);
    }

    static class Pair {
        int start, end;

        public Pair(int start, int end, int cnt) {
            this.start = start;
            this.end = end;
        }
    }
}
