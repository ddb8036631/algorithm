package bruteforce;

import java.util.Scanner;

public class SWEA_4366_정식이의은행업무 {
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			char[] two = sc.next().toCharArray();
			char[] three = sc.next().toCharArray();
			
			for(int i=0; i<two.length; i++) {
				if(two[i] == '0') {
					two[i] = '1';
					changeThree(two, three);
					two[i] = '0';
				} else if(two[i] == '1') {
					two[i] = '0';
					changeThree(two, three);
					two[i] = '1';
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static void changeThree(char[] two, char[] three) {
		for(int j=0; j<three.length; j++) {
			if(three[j] == '0') {
				three[j] = '1';
				check(two, three);
				
				three[j] = '2';
				check(two, three);
				
				three[j] = '0';
			} else if(three[j] == '1') {
				three[j] = '0';
				check(two, three);
				three[j] = '2';
				check(two, three);
				
				three[j] = '1';
			} else if(three[j] == '2') {
				three[j] = '0';
				check(two, three);
				three[j] = '1';
				check(two, three);
				
				three[j] = '2';
			}
		}
	}
	
	static void check(char[] two, char[] three) {
		String stwo = "";
		String sthree = "";
		
		for(int i=0; i<two.length; i++) stwo += two[i];
		for(int i=0; i<three.length; i++) sthree += three[i];
		
		int twoNum = Integer.parseInt(stwo, 2);
		int threeNum = Integer.parseInt(sthree, 3);
		
		if(twoNum == threeNum)
			ans = twoNum;
	}
}
