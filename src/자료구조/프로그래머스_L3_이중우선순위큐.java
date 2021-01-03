package 자료구조;

import java.util.PriorityQueue;

public class 프로그래머스_L3_이중우선순위큐 {
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> ascending = new PriorityQueue<>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> descending = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (String s : operations) {
            String[] ss = s.split(" ");
            if (ss[0].equals("I")) {
                ascending.add(Integer.parseInt(ss[1]));
                descending.add(Integer.parseInt(ss[1]));
            } else if (ss[0].equals("D") && !ascending.isEmpty()) {
                if (Integer.parseInt(ss[1]) == 1) {
                    int max = descending.poll();
                    ascending.remove(max);
                } else if (Integer.parseInt(ss[1]) == -1) {
                    int min = ascending.poll();
                    descending.remove(min);
                }
            }
        }

        if (!ascending.isEmpty()) {
            answer[0] = descending.peek();
            answer[1] = ascending.peek();
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] operations = {"I 16", "D 1"};

        solution(operations);
    }
}