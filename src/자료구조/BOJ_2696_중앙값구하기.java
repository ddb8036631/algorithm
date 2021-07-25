package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2696_중앙값구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            int M = Integer.parseInt(br.readLine());
            int inputIdx = 0, outputIdx = 0, cnt = 1;
            PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

            answer.append((M + 1) / 2);
            answer.append("\n");

            while (true) {
                if (inputIdx > M) break;

                String input = br.readLine();
                st = new StringTokenizer(input);

                while (st.hasMoreTokens()) {
                    int num = Integer.parseInt(st.nextToken());

                    if (minHeap.isEmpty() && maxHeap.isEmpty()) {
                        maxHeap.add(num);
                    } else if (maxHeap.size() > minHeap.size()) {
                        if (num > maxHeap.peek()) {
                            minHeap.add(num);
                        } else {
                            minHeap.add(maxHeap.poll());
                            maxHeap.add(num);
                        }
                    } else {
                        if (num > maxHeap.peek()) {
                            minHeap.add(num);
                            maxHeap.add(minHeap.poll());
                        } else {
                            maxHeap.add(num);
                        }
                    }

                    if (cnt % 2 == 1) {
                        outputIdx++;
                        answer.append(maxHeap.peek() + (outputIdx % 10 == 0 ? "\n" : " "));
                    }
                    cnt++;
                }

                inputIdx += 10;
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }
}
