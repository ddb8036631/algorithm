package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815_숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        Arrays.sort(nums);

        while (st.hasMoreTokens()) {
            int target = Integer.parseInt(st.nextToken());
            int low = 0, high = nums.length - 1;
            boolean find = false;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (target > nums[mid]) {
                    low = mid + 1;
                } else if (target < nums[mid]) {
                    high = mid - 1;
                } else {
                    find = true;
                    break;
                }
            }

            if (find) answer.append("1 ");
            else answer.append("0 ");
        }

        System.out.println(answer);
    }
}
