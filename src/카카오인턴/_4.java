package 카카오인턴;

import java.util.LinkedList;
import java.util.Queue;

public class _4 {
    public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0, roads));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.idx == end) {
                return now.dist;
            }

            boolean isTrap = false;

            for (int trapNum : traps) {
                if (now.idx == trapNum) {
                    isTrap = true;
                    break;
                }
            }

            if (isTrap) {
                int[][] tmpMap = new int[now.map.length][3];

                for (int i = 0; i < now.map.length; i++) {
                    for (int j = 0; j < 3; j++) {
                        tmpMap[i][j] = now.map[i][j];
                    }
                }

                for (int i = 0; i < tmpMap.length; i++) {
                    if (now.idx == tmpMap[i][0] || now.idx == tmpMap[i][1]) {
                        int tmp = tmpMap[i][0];
                        tmpMap[i][0] = tmpMap[i][1];
                        tmpMap[i][1] = tmp;
                    }
                }

                now.map = tmpMap;
            }

            for (int i = 0; i < roads.length; i++) {
                if (now.idx == now.map[i][0]) {
                    q.add(new Node(now.map[i][1], now.dist + now.map[i][2], now.map));
                }
            }
        }

        return answer;
    }

    static class Node {
        int idx, dist;
        int[][] map;

        public Node(int idx, int dist, int[][] map) {
            this.idx = idx;
            this.dist = dist;
            this.map = map;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 1, 3, new int[][]{{1, 2, 2}, {3, 2, 3}}, new int[]{2}));
        System.out.println(solution(4, 1, 4, new int[][]{{1, 2, 1}, {3, 2, 1}, {2, 4, 1}}, new int[]{2, 3}));

    }
}
