package 프로그래머스_Level1;

import java.util.ArrayList;
import java.util.Collections;

public class K번째수 {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int n = 0; n < commands.length; n++) {
        	int i = commands[n][0];
        	int j = commands[n][1];
        	int k = commands[n][2];
        	
        	ArrayList<Integer> list = new ArrayList<>();
        	for(int idx = i-1; idx <= j-1; idx++) {
        		list.add(array[idx]);
        	}
        	
        	Collections.sort(list);
        	answer[n] = list.get(k-1);
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {
				{ 2, 5, 3},
				{4, 4, 1},
				{1, 7, 3},
		};
		
		int[] answer = solution(array, commands);
		for(int i=0; i<answer.length; i++)
			System.out.println(answer[i]);
	}
}
