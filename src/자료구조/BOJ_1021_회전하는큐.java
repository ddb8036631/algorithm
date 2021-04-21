package 자료구조;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_1021_회전하는큐 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int answer = 0;

        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1; i<=N;i++) list.add(i);

        for(int i=0;i<M;i++) {
            int target = sc.nextInt();
            if(list.peek() == target) {
                list.poll();
            } else {
//                if(list.indexOf(target) > list.size())
            }
         }

    }
}
