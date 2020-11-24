package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_7662_이중우선순위큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {

            // key : 큐에 들어오는 값, value : 해당 key의 개수.
            TreeMap<Long, Integer> treeMap = new TreeMap<>();

            int K = Integer.parseInt(br.readLine());
            for (int k = 0; k < K; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char op = st.nextToken().charAt(0);
                long value = Long.parseLong(st.nextToken());

                if (op == 'I') {
                    if (treeMap.containsKey(value)) {
                        treeMap.put(value, treeMap.get(value) + 1);
                    } else {
                        treeMap.put(value, 1);
                    }
                } else if (op == 'D') {
                    if (treeMap.size() == 0) continue;

                    if (value == 1) {
                        if (treeMap.get(treeMap.lastKey()) == 1)
                            treeMap.remove(treeMap.lastKey());
                        else
                            treeMap.put(treeMap.lastKey(), treeMap.get(treeMap.lastKey()) - 1);
                    } else if (value == -1) {
                        if (treeMap.get(treeMap.firstKey()) == 1)
                            treeMap.remove(treeMap.firstKey());
                        else
                            treeMap.put(treeMap.firstKey(), treeMap.get(treeMap.firstKey()) - 1);
                    }
                }
            }

            if (treeMap.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(treeMap.lastKey() + " " + treeMap.firstKey() + "\n");
            }
        }

        System.out.println(sb);
    }
}
