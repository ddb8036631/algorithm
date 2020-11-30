package 프로그래머스_Level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
    public static List solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            queue.add(day);
        }

        while(!queue.isEmpty()) {
            int now = queue.peek();
            int count = 0;

            while(!queue.isEmpty() && queue.peek() <= now) {
                count++;
                queue.poll();
            }

            answer.add(count);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
//        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 1, 1, 1, 1, 1};

        solution(progresses, speeds);
    }
}
