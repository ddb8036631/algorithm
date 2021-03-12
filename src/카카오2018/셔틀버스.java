package 카카오2018;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class 셔틀버스 {
    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        Arrays.sort(timetable, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] o1_splited = o1.split(":");
                String[] o2_splited = o2.split(":");

                if (o1_splited[0].equals(o2_splited[0]))
                    return o1_splited[1].compareTo(o2_splited[1]);
                return o1_splited[0].compareTo(o2_splited[0]);
            }
        });

        Map<Integer, String> map = new HashMap<>();
        String now = "09:00";

        for (int i = 0; i < n; i++) {
            map.put(i, now);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime next = LocalTime.parse(now, dtf).plusMinutes(t);

            now = next.toString();
        }

        List<String>[] schedule = new ArrayList[map.size()];
        for (int i = 0; i < schedule.length; i++)
            schedule[i] = new ArrayList<>();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        int idx_schedule = 0;
        int idx_timetable = 0;

        while (idx_schedule < schedule.length && idx_timetable < timetable.length) {
            LocalTime lt_schedule = LocalTime.parse(map.get(idx_schedule), dtf);
            LocalTime lt_timetable = LocalTime.parse(timetable[idx_timetable], dtf);

            if (schedule[idx_schedule].size() + 1 <= m && (lt_timetable.isBefore(lt_schedule) || lt_timetable.equals(lt_schedule))) {
                schedule[idx_schedule].add(timetable[idx_timetable]);
                idx_timetable++;
            } else
                idx_schedule++;
        }

        int last = schedule.length - 1;

        if (schedule[last].size() + 1 <= m) {
            answer = map.get(last);
        } else {
            for (int j = 0; j < schedule[last].size(); j++) {
                LocalTime tmp = LocalTime.parse(schedule[last].get(j), dtf).minusMinutes(1);

                if (j + 1 <= m) {
                    answer = tmp.toString();
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"});
//        solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"});
//        solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"});
//        solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"});
//        solution(1, 1, 1, new String[]{"23:59"});
//        solution(10, 60, 45, new String[]{"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"});
    }
}
