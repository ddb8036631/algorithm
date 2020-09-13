package bruteforce;

import java.util.Scanner;

public class SWEA_4366_정식이의은행업무2 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
 
        for (int tc = 1; tc <= TC; tc++) {
            String str2 = sc.next();
            String str3 = sc.next();
 
            int num2 = Integer.parseInt(str2, 2);
            int num3 = Integer.parseInt(str3, 3);
 
            for (int i = 0; i < str2.length() && (num2 != num3); i++) {
                char ch = str2.charAt(i) == '1' ? '0' : '1';
                num2 = Integer.parseInt(str2.substring(0, i) + ch + str2.substring(i + 1), 2);
 
                for (int j = 0; j < str3.length() && (num2 != num3); j++) {
                    for (int k = 0; k < 3 && (num2 != num3); k++) {
                        if (str3.charAt(j) - '0' == k)
                            continue;
 
                        num3 = Integer.parseInt(str3.substring(0, j) + (char) (k + '0') + str3.substring(j + 1), 3);
                    }
                }
            }
 
            System.out.println("#" + tc + " " + num2);
        }
    }
}
