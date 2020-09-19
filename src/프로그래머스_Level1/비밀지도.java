package 프로그래머스_Level1;

public class 비밀지도 {
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		
		for(int i=0; i<n; i++) {
			int num = arr1[i] | arr2[i];
			answer[i] = Integer.toBinaryString(num);
			
			answer[i] = String.format("%" + n + "s", answer[i]);
			
			answer[i] = answer[i].replace('1', '#');
			answer[i] = answer[i].replace('0', ' ');
		}

		return answer;
	}
	
	public static void main(String[] args) {
		int n1 = 5;
		int[] arr1_1 = {9, 20, 28, 18, 11};
		int[] arr1_2 = {30, 1, 21, 17, 28};
		
		int n2 = 6;
		int[] arr2_1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2_2 = {27 ,56, 19, 14, 14, 10};

//		solution(n1, arr1_1, arr1_2);
		solution(n2, arr2_1, arr2_2);
	}
}
