package 카카오2018;

public class 방금그곡 {
    public static String solution(String m, String[] musicinfos) {
        m = convert(m);

        String answer = "(None)";
        int max = 0;

        for (int i = 0; i < musicinfos.length; i++) {
            String s = musicinfos[i];

            String[] info = s.split(",");

            String[] start = info[0].split(":");
            String[] end = info[1].split(":");
            String name = info[2];
            String akbo = info[3];

            int playTime = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
            if (!start[0].equals(end[0])) {
                int hour_diff = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
                playTime += 60 * hour_diff;
            }

            String melody = makeMelody(akbo, playTime);
            melody = convert(melody);

            if (melody.contains(m)) {
                if (max < playTime) {
                    max = playTime;
                    answer = name;
                }
            }
        }

        return answer;
    }

    public static String convert(String melody) {
        melody = melody.replaceAll("A#", "a");
        melody = melody.replaceAll("C#", "c");
        melody = melody.replaceAll("D#", "d");
        melody = melody.replaceAll("F#", "f");
        melody = melody.replaceAll("G#", "g");

        return melody;
    }

    public static String makeMelody(String akbo, int playTime) {
        String melody = "";
        int cnt = 0;
        int idx = 0;

        while (cnt < playTime) {
            if (idx + 1 < akbo.length() && akbo.charAt(idx + 1) == '#') {
                melody += akbo.substring(idx, idx + 2);
                idx += 2;
            } else {
                melody += akbo.charAt(idx);
                idx += 1;
            }

            idx = idx % akbo.length();
            cnt++;
        }

        return melody;
    }

    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};

//        String m = "CC#BCC#BCC#BCC#B";
//        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};

//        String m = "ABC";
//        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

//        String m = "CCB";
//        String[] musicinfos = {"03:00,03:10,FOO,CCB#CCB", "04:00,04:08,BAR,ABC"};

        solution(m, musicinfos);
    }
}
