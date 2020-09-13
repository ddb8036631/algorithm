package 완전탐색;

import java.util.Scanner;

// 1. 오른쪽이 무거워진 순간 더이상 해볼 필요 없음.
// 2. 남은 추를 다 오른쪽에 놔도 무거워지지 않는 경우.
public class SWEA_3234_준환이의양팔저울_SOL {
	static int N; 			// 추의 개수
	static int[] weight; 	// 추들의 무게
	static int ans; 		// 추를 올려놓기 가능한 모든 경우의 
	static boolean[] used; 	// 앞에 올려놓은 추 제외하고 놔볼 때 사용할 배열
	
	static int[] facto; 	// factorial 미리 계산해서 1!~9! 저장해두기
	static int[] pow; 		// 2의 거듭제곱 미리 계산해서 저장해두기
	static int totalWeight; // 모든 추의 무게 합산해서 현재 올려둔 추 빼고 나머지 얼만큼인지 보기!
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc=1; tc<=TC; tc++) {
			N = sc.nextInt();
			
			weight = new int[N];
			used = new boolean[N];
			
			facto = new int[N+1];
			pow = new int[N+1];
			facto[0] = facto[1] = pow[0] = 1;
			totalWeight = 0;
			
			for(int i=0; i<N; i++) {
				weight[i] = sc.nextInt();
				facto[i+1] = facto[i] * (i+1);	// 1! ~ 9!
				pow[i+1] = pow[i] * 2;			// 2^1 ~ 2^9
				totalWeight += weight[i]; 		// 추들의 총 무게 합
			}
			
			ans = 0;
			
			perm(0, 0, 0, totalWeight);
		}
	}
	
	static void perm(int idx, int leftSum, int rightSum, int remain) {
		if(remain+rightSum <= leftSum) { // 남은 추를 다 오른쪽에 놔도 왼쪽보다 안무거운 경우.
			ans += facto[N-idx] * pow[N-idx];
			return;
		}
		
		if(idx == N) { // N개의 추를 다 놔봤다!
			ans++;		// 경우의 수 하나 증가!
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!used[i]) { // 미사용중인 i번째 추다! 놔보자!
				used[i] = true; // 내 이후의 재귀는 이 추 못쓴다~
				
				perm(idx+1, leftSum+weight[i], rightSum, remain-weight[i]);
				if(rightSum+weight[i] <= leftSum) { // 오른쪽에 추를 놔도 왼쪽 이하여야 함!
					perm(idx+1, leftSum, rightSum+weight[i], remain-weight[i]);
				}
				
				used[i] = false;
			}
		}
	}
}
