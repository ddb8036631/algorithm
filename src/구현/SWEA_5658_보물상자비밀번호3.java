package 구현;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SWEA_5658_보물상자비밀번호3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			String s = sc.next();
			
			List<Integer> list = new ArrayList<>();
			for(int i=0; i<N/4; i++) {
				int start = 0;
				int end = N/4;
				
				// 네 면을 돔.
				for(int j=0; j<4; j++) {
					int num = Integer.parseInt(s.substring(start, end), 16);
					if(!list.contains(num)) list.add(num);
					start = end;
					end += N/4;
				}
				char c = s.charAt(N-1);
				s = c + s.substring(0, N-1);
			}
			Collections.sort(list, Collections.reverseOrder());
			System.out.println(list.get(K-1));
		}
	}
}
