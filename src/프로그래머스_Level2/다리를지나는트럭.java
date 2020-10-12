package 프로그래머스_Level2;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int max = 0;
        int time = 0;
        
        for(int w : truck_weights) {
        	while(true) {
        		if(queue.isEmpty()) {
        			queue.add(w);
        			time++;
        			max += w;
        			break;
        		} else if(queue.size() == bridge_length) {
        			max -= queue.poll();
        		} else {
        			if(max + w > weight) {
        				queue.add(0);
        				time++;
        			} else {
        				queue.add(w);
        				time++;
        				max += w;
        				break;
        			}
        		}
        	}
        }
        
        return time + bridge_length;
    }
    
	public static void main(String[] args) {
		int bridge_length1 = 2;
		int weight1 = 10;
		int[] truck_weights1 = { 7, 4, 5, 6 };
		
		int bridge_length2 = 100;
		int weight2 = 100;
		int[] truck_weights2 = { 10 };

		int bridge_length3 = 100;
		int weight3 = 100;
		int[] truck_weights3 = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		
		solution(bridge_length1, weight1, truck_weights1);
	}
}
