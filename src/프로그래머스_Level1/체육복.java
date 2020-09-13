package 프로그래머스_Level1;

import java.util.Arrays;

public class 체육복 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] arr = new int[n+1];
        Arrays.fill(arr, 1);
        
        // 잃어버린 사람 감소 시켜주기.
        for(int i=0; i< lost.length; i++) {
        	arr[lost[i]]--;
        }
        
        // 여벌이 하나 더 있는 사람 표시해주기.
        for(int i=0; i<reserve.length; i++) {
        	arr[reserve[i]]++;
        }
        
        // 체육복 빌려주기.
        for(int i=1; i<=n; i++) {
        	if(arr[i] == 2 && i-1>=1 && arr[i-1] == 0) {
        		arr[i-1]++;
        		arr[i]--;
        	}
        	if(arr[i] == 2 && i+1 <= n && arr[i+1] == 0) {
        		arr[i+1]++;
        		arr[i]--;
        	}
        }
        
        for(int i=1; i<=n; i++) {
        	if(arr[i] >= 1)
        		answer++;
        }
        
        System.out.println(answer);
        
        return answer;
    }
    
	public static void main(String[] args) {
//		int n = 5;
//		int[] lost = {2, 4};
//		int[] reserve = {1, 3, 5};
//		int n = 5;
//		int[] lost = {2, 4};
//		int[] reserve = {3};
		int n = 3;
		int[] lost = {3};
		int[] reserve = {1};
		
		solution(n ,lost, reserve);
	}
}
