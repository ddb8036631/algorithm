package simulation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SWEA_5658_보물상자비밀번호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
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
				for(int j=0; j<4; j++) {
					String hex = s.substring(start, end);
					int num = Integer.parseInt(hex, 16);
					if(!list.contains(num)) list.add(num);
					start = end;
					end += N/4;
				}
				char c = s.charAt(N-1);
				s = c+s.substring(0, N-1);
			}
			Collections.sort(list);
			System.out.println("#"+tc+" "+list.get(list.size()-K));
		}
	}
}
