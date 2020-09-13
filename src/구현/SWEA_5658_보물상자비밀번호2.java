package 구현;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SWEA_5658_보물상자비밀번호2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int tc=1; tc<=TC; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			String s = sc.next();
			String t = s + s.substring(0, N/4 - 1);
			
			List<Integer> list = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				String hex = t.substring(i, i+N/4);
				int num = Integer.parseInt(hex, 16);
				if(!list.contains(num)) list.add(num);
			}
			Collections.sort(list, Collections.reverseOrder());
			System.out.println("#"+tc+" "+list.get(K-1));
		}
	}
}
