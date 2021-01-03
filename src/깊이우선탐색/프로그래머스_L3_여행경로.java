package 깊이우선탐색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 프로그래머스_L3_여행경로 {
    static ArrayList<ArrayList<String>> list;

    public static ArrayList<String> solution(String[][] tickets) {
        boolean[] used = new boolean[tickets.length];
        list = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN") && !used[i]) {
                path.clear();

                path.add("ICN");
                path.add(tickets[i][1]);

                dfs(i, tickets, used, 1, path);
            }
        }

        Collections.sort(list, new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                int idx = 0;
                while (idx < o1.size() - 1 && o1.get(idx).equals(o2.get(idx)))
                    idx++;

                return o1.get(idx).compareTo(o2.get(idx));
            }
        });

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get(0).equals("ICN"))

                return list.get(i);
        }
        return list.get(0);
    }

    public static void dfs(int idx, String[][] tickets, boolean[] used, int cnt, ArrayList<String> path) {
        used[idx] = true;

        if (cnt == tickets.length) {
            ArrayList<String> tmp = new ArrayList<>();
            for (String s : path) {
                tmp.add(s);
            }

            list.add(tmp);
            used[idx] = false;

            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[idx][1].equals(tickets[i][0]) && !used[i]) {
                path.add(tickets[i][1]);
                dfs(i, tickets, used, cnt + 1, path);
                path.remove(path.size() - 1);
            }
        }

        used[idx] = false;
    }

    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
//        String[][] tickets = {{"ICN", "A"}, {"A", "C"}, {"A", "D"}, {"D", "B"}, {"B", "A"}};
//        String[][] tickets = {{"ICN", "A"}, {"ICN", "A"}, {"A", "ICN"}};
//        String[][] tickets = {{"ICN", "A"}, {"A", "B"}, {"B", "A"}, {"A", "ICN"},{"ICN", "A"}};
//        String[][] tickets = {{"ICN", "A"}, {"ICN", "A"}, {"ICN", "A"}, {"A", "ICN"},{"A", "ICN"}};
//        String[][] tickets = {{"ICN", "A"}, {"ICN", "B"}, {"B", "ICN"}};
        String[][] tickets = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"},
                {"BOO", "ICN"}, {"COO", "BOO"}};

        solution(tickets);
    }
}
