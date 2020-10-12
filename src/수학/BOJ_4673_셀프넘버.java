package 수학;

import java.util.Arrays;

public class BOJ_4673_셀프넘버 {
	public static void main(String[] args) {
		boolean[] selfNumber = new boolean[10001];
		Arrays.fill(selfNumber, true);

		for (int i = 1; i <= 10000; i++) {
			int j = i;
			int createdNumber = j;
			while (j != 0) {
				createdNumber += j % 10;
				j /= 10;
			}

			if (createdNumber <= 10000 && createdNumber != i)
				selfNumber[createdNumber] = false;
		}

		for (int i = 1; i <= 10000; i++)
			if (selfNumber[i])
				System.out.println(i);
	}
}
