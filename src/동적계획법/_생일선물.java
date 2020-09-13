package 동적계획법;

public class _생일선물 {
	static final int N = 4;
	static final int MAX = 10;
	
	public static void main(String[] args) {
		int[] value = new int[N+1];
		int[] weight = new int[N+1];
		
		value[1]=10;weight[1]=5;
		value[2]=40;weight[2]=4;
		value[3]=30;weight[3]=6;
		value[4]=50;weight[4]=3;
		
		int[][] memo = new int[N+1][MAX+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=MAX; j++) {
				if(weight[i] > j) {
					memo[i][j] = memo[i-1][j];
				} else {
					int val1 = memo[i-1][j-weight[i]] + value[i];
					int val2 = memo[i-1][j];
					memo[i][j] = Math.max(val1, val2);
				}
			}
		}
		
		System.out.println(memo[N][MAX]);
	}
}
