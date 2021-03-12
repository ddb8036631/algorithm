package 카카오2019;

import java.util.*;

public class 오픈채팅방 {
    public static List<String> solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        List<Pair> list = new ArrayList<>();

        for (String s : record) {
            String[] splited = s.split(" ");

            if (splited[0].equals("Enter")) {
                map.put(splited[1], splited[2]);
                list.add(new Pair(splited[1], "Enter"));
            } else if (splited[0].equals("Leave")) {
                list.add(new Pair(splited[1], "Leave"));
            } else if (splited[0].equals("Change")) {
                map.put(splited[1], splited[2]);
            }
        }

        for (Pair pair : list) {
            answer.add(map.get(pair.uid) + "님이 " + (pair.status == "Enter" ? "들어왔습니다." : "나갔습니다."));
        }

        return answer;
    }

    private static class Pair {
        String uid;
        String status;

        public Pair(String uid, String status) {
            this.uid = uid;
            this.status = status;
        }
    }

    public static void main(String[] args) {
        solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
    }
}
