package 카카오2018;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class 추석트래픽 {
    public static int solution(String[] lines) {
        final int NANO = 1000000000;
        int answer = 0;
        String[] S = new String[lines.length];
        String[] T = new String[lines.length];

        for (int i = 0; i < lines.length; i++) {
            int len = lines[i].length();
            lines[i] = lines[i].substring(0, len - 1);

            String[] tmp = lines[i].split(" ");
            S[i] = tmp[0] + " " + tmp[1];
            T[i] = tmp[2];
        }

        ArrayList<Time> list = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        for (int i = 0; i < lines.length; i++) {
            LocalDateTime start = LocalDateTime.parse(S[i], dtf).minusNanos((long) (Double.parseDouble(T[i]) * NANO)).plusNanos((long) (0.001 * NANO));
            list.add(new Time(start, LocalDateTime.parse(S[i], dtf)));
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            LocalDateTime start = list.get(i).start;
            LocalDateTime end = list.get(i).end;
            LocalDateTime startPlusOne = start.plusSeconds(1).minusNanos((long) (0.001 * NANO));
            LocalDateTime endPlusOne = end.plusSeconds(1).minusNanos((long) (0.001 * NANO));

            int cntStart = 0, cntEnd = 0;
            for (int j = 0; j < list.size(); j++) {
                LocalDateTime targetStart = list.get(j).start;
                LocalDateTime targetEnd = list.get(j).end;

                if ((targetStart.isBefore(startPlusOne) || targetStart.equals(startPlusOne)) && (targetEnd.isAfter(start) || targetEnd.equals(start)))
                    cntStart++;

                if ((targetStart.isBefore(endPlusOne) || targetStart.equals(endPlusOne)) && (targetEnd.isAfter(end) || targetEnd.equals(end)))
                    cntEnd++;

                answer = Math.max(answer, cntStart);
                answer = Math.max(answer, cntEnd);
            }
        }

        return answer;
    }

    public static class Time implements Comparable<Time> {
        LocalDateTime start;
        LocalDateTime end;

        public Time(LocalDateTime start, LocalDateTime end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            return this.start.equals(o.start) ? this.end.compareTo(o.end) : this.start.compareTo(o.start);
        }
    }

    public static void main(String[] args) {
        solution(new String[]{"2016-09-15 00:00:00.000 3s"});
//        solution(new String[]{"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"});
//        solution(new String[]{"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"});
//        solution(new String[]{"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s",
//                "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"});
    }
}
