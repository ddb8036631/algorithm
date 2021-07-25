package 그리디;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SWEA_4050_재관이의대량할인 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			int N = sc.nextInt();
			List<Integer> list = new ArrayList<>();
			
			int sum = 0;
			for(int i=0; i<N; i++) {
				int price = sc.nextInt();
				sum += price;
				list.add(price);
			}
			
			Collections.sort(list, Collections.reverseOrder());
			
			for(int i=0; i<list.size(); i++) {
				if((i+1)%3 == 0)
					sum -= list.get(i);
			}
			
			System.out.println("#"+tc+" "+sum);
		}
	}
}
