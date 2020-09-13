package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1798_범준이의제주도계획 {
	static StringBuilder output = new StringBuilder();
	static int T;

	static int N; // . 지점 개수 N은 3이상 35이하이다.
	static int M; // 휴가기간 M은 1이상 5이하이다.
	// 각 정점을 연결할 그래프
	static int[][] graph;

	// 관리할 지점들..
	static Point airport;
	static List<Point> hotels;
	static List<Point> tourSpots;

	// 최대 만족도
	static int maxSatis;
	static List<Integer> maxSatisPath;

	// 탐색에 사용할 임시 경로
	static Stack<Integer> tempPath;

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		T = Integer.parseInt(input.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());

			// 1. 그래프 구성
			graph = new int[N + 1][N + 1];
			// 다음 N-1개 줄에는 지점간의 이동 소요시간 정보가 주어지는데,
			// i번째 줄에는 i번째 지점으로부터 i+1 ~ N번 지점까지의 이동 소요시간이 공백으로 구분되어 주어진다.
			// 해당 경로는 반대로 갈 때도 동일한 이동 소요시간을 갖는다.
			for (int r = 1; r < N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for (int c = r + 1; c < graph.length; c++) {
					graph[c][r] = graph[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}

			/*
			 * System.out.println("그래프 확인"); for(int [] row : graph) {
			 * System.out.println(Arrays.toString(row)); }
			 */

			// 2. 지점 정보 가져오기
			tourSpots = new ArrayList<>();
			hotels = new ArrayList<>();

			for (int n = 1; n <= N; n++) {
				tokens = new StringTokenizer(input.readLine());
				String type = tokens.nextToken();
				if (type.equals("H")) {
					hotels.add(new Point(type, n));
				} else if (type.equals("A")) {
					airport = new Point(type, n);
				} else {
					int playTime = Integer.parseInt(tokens.nextToken());
					int satis = Integer.parseInt(tokens.nextToken());
					tourSpots.add(new Point(type, n, playTime, satis));
				}
			}

			/*
			 * System.out.println(airport); System.out.println(hotels);
			 * System.out.println(tourSpots);
			 */

			// 3. 관광지에 가장 가까운 호텔 정보 설정해주기. - graph
			for (Point p : tourSpots) {
				int min = Integer.MAX_VALUE;
				for (Point h : hotels) {
					if (graph[p.idx][h.idx] < min) {
						min = graph[p.idx][h.idx];
						p.nearH = h;
					}
				}
			}

			/*
			 * System.out.println("가장 가까운 호텔은?"); for(Point p: tourSpots) {
			 * System.out.println(p+ " :"+p.nearH); }
			 */

			// 4. 여행 준비
			maxSatis = Integer.MIN_VALUE;
			tempPath = new Stack<>();

			solve(0, airport, 0, 0, new boolean[N + 1]);

			// 5. 결과 출력
			output.append("#").append(t).append(" ");
			if (maxSatis == Integer.MIN_VALUE) {
				output.append(0);
			} else {
				output.append(maxSatis).append(" ");
				for (int i : maxSatisPath) {
					output.append(i).append(" ");
				}
			}
			output.append("\n");
		}
		System.out.println(output);
	}

	static void solve(int day, Point start, int satis, int time, boolean[] visited) {
		// 종료조건?
		if (day == M) {
			if (satis > maxSatis) {
				maxSatis = satis;
				// 최대 만족도에서의 경로 전달
				maxSatisPath = new ArrayList<>(tempPath);
			}
			return;
		}

		// 일반 탐색.
		boolean canGoNext = false;

		for (Point point : tourSpots) {
			// 갈수 있는 지점들을 찾아서 계속 돌아다닌다.
			if (!visited[point.idx]) {
				// 미방문이라면.. 그 지점을 갈 수 있는지 시간을 계산해볼 필요가 있다.
				int tempTime = time + graph[start.idx][point.idx] + point.playTime;
				if (day == M - 1) {
					tempTime += graph[point.idx][airport.idx];
				} else {
					tempTime += graph[point.idx][point.nearH.idx];
				}

				if (tempTime > 540) {
					continue;
				}
				canGoNext = true;
				visited[point.idx] = true;
				tempPath.push(point.idx);
				solve(day, point, satis + point.satis, time + graph[start.idx][point.idx] + point.playTime, visited);
				tempPath.pop();
				visited[point.idx] = false;
			}
		}

		// 관광지로 못가면 날짜에 따라서 공항/호텔로 이동
		if (!canGoNext) {
			if (day == M - 1) {
				tempPath.push(airport.idx);
				solve(day+1, airport, satis, 0, visited);
				tempPath.pop();
			} else {
				for(Point hotel: hotels) {
					if(time + graph[start.idx][hotel.idx] <= 540) {
						tempPath.push(hotel.idx);
						solve(day+1, hotel, satis, 0, visited);
						tempPath.pop();
					}
				}
			}
		}
	}

	static class Point {
		String type;// A, H, P
		int idx;
		int playTime;
		int satis;
		Point nearH;

		public Point(String type, int idx) {
			this(type, idx, 0, 0);
		}

		public Point(String type, int idx, int playTime, int satis) {
			super();
			this.type = type;
			this.idx = idx;
			this.playTime = playTime;
			this.satis = satis;
		}

		@Override
		public String toString() {
			return "Point [type=" + type + ", idx=" + idx + ", playTime=" + playTime + ", satis=" + satis + "]";
		}

	}

	static String src = "1\r\n" +
			"10 3\r\n" +
			"60 90 100 110 240 40 30 60 30\r\n" +
			"60 120 140 200 120 100 60 60\r\n" +
			"90 110 170 100 100 30 90\r\n" +
			"50 110 40 80 90 90\r\n" +
			"70 30 50 90 90\r\n" +
			"100 140 180 120\r\n" +
			"40 90 40\r\n" +
			"100 20\r\n" +
			"70\r\n" +
			"A\r\n" +
			"P 240 6\r\n" +
			"P 120 4\r\n" +
			"P 240 5\r\n" +
			"P 60 4\r\n" +
			"P 200 6\r\n" +
			"P 180 1\r\n" +
			"P 180 1\r\n" +
			"H\r\n" +
			"H";
}
