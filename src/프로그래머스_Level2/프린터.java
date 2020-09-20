package 프로그래머스_Level2;

import java.util.Collections;
import java.util.PriorityQueue;

public class 프린터 {
    public static int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int priority : priorities)
        	pq.add(priority);
        
        while(!pq.isEmpty()) {
        	for(int i=0; i<priorities.length; i++) {
        		int priority = priorities[i];
        		
        		if(priority == (int) pq.peek()) {
        			if(i == location) {
        				return answer;
        			}
        			pq.poll();
        			answer++;
        		}
        	}
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
		int[] priorities1 = {2, 1, 3, 2};
		int location1 = 2;

		int[] priorities2 = {1, 1, 9, 1, 1, 1};
		int location2 = 0;
		
		System.out.println(solution(priorities1, location1));
		System.out.println(solution(priorities2, location2));
	}
}
