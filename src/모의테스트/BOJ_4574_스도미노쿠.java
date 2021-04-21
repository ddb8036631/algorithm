package 모의테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4574_스도미노쿠 {
    static final int SIZE = 9;
    static int N;
    static int[][] map;
    static boolean[][] row, col, square, domino;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static StringBuilder answer = new StringBuilder();
    static int TC = 0;
    static boolean found;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while ((N = Integer.parseInt(br.readLine().trim())) != 0) {
            TC++;
            found = false;
            map = new int[SIZE][SIZE];
            row = new boolean[SIZE][SIZE + 1];
            col = new boolean[SIZE][SIZE + 1];
            square = new boolean[SIZE][SIZE + 1];
            domino = new boolean[SIZE + 1][SIZE + 1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int U, V;
                int[] LU, LV;

                U = Integer.parseInt(st.nextToken());
                LU = charArrToIntArr(st.nextToken().toCharArray());
                V = Integer.parseInt(st.nextToken());
                LV = charArrToIntArr(st.nextToken().toCharArray());

                map[LU[0]][LU[1]] = U;
                map[LV[0]][LV[1]] = V;

                row[LU[0]][U] = col[LU[1]][U] = row[LV[0]][V] = col[LV[1]][V] = true;
                square[getSquareIdx(LU[0], LU[1])][U] = square[getSquareIdx(LV[0], LV[1])][V] = true;
                domino[U][V] = domino[V][U] = true;
            }

            st = new StringTokenizer(br.readLine());

            for (int num = 1; num <= SIZE; num++) {
                int[] pos = charArrToIntArr(st.nextToken().toCharArray());

                map[pos[0]][pos[1]] = num;

                row[pos[0]][num] = col[pos[1]][num] = true;
                square[getSquareIdx(pos[0], pos[1])][num] = true;
                domino[num][num] = true;
            }

            dfs(0);
        }

        System.out.println(answer);
    }

    static void dfs(int cnt) {
        if (cnt == 81) {
            found = true;
            answer.append("Puzzle " + TC + "\n");

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    answer.append(map[i][j]);
                }
                answer.append('\n');
            }

            return;
        }

        if (found) return;

        int x = cnt / 9, y = cnt % 9;

        if (map[x][y] != 0) {
            dfs(cnt + 1);
            return;
        }

        for (int first = 1; first <= SIZE; first++) {
            if (canPut(x, y, first)) {
                row[x][first] = col[y][first] = square[getSquareIdx(x, y)][first] = true;
                map[x][y] = first;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d], ny = y + dy[d];

                    if (!isInRange(nx, ny) || map[nx][ny] != 0) continue;

                    for (int second = 1; second <= SIZE; second++) {
                        if (!domino[first][second] && !domino[second][first] && canPut(nx, ny, second)) {
                            row[nx][second] = col[ny][second] = square[getSquareIdx(nx, ny)][second] = true;
                            map[nx][ny] = second;
                            domino[first][second] = domino[second][first] = true;

                            dfs(cnt + 1);

                            row[nx][second] = col[ny][second] = square[getSquareIdx(nx, ny)][second] = false;
                            map[nx][ny] = 0;
                            domino[first][second] = domino[second][first] = false;
                        }
                    }
                }

                row[x][first] = col[y][first] = square[getSquareIdx(x, y)][first] = false;
                map[x][y] = 0;
            }
        }
    }

    static int[] charArrToIntArr(char[] charArr) {
        return new int[]{charArr[0] - 'A', charArr[1] - '0' - 1};
    }

    static int getSquareIdx(int x, int y) {
        return x / 3 * 3 + y / 3;
    }

    static boolean canPut(int x, int y, int num) {
        return !row[x][num] && !col[y][num] && !square[getSquareIdx(x, y)][num];
    }

    static boolean isInRange(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
    }
}
