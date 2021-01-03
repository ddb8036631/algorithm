package 자료구조;

import java.util.*;

public class 프로그래머스_L3_베스트앨범 {
    public static ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        Map<String, Info> hashMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (!hashMap.containsKey(genres[i])) {
                ArrayList<int[]> tmp = new ArrayList<>();
                tmp.add(new int[]{plays[i], i});
                Info info = new Info(plays[i], tmp);

                hashMap.put(genres[i], info);
            } else {
                Info info = hashMap.get(genres[i]);
                info.sum += plays[i];
                info.list.add(new int[]{plays[i], i});

                hashMap.put(genres[i], info);
            }
        }

        // 각 장르의 총 재생 횟수를 기준으로 내림차순 정렬합니다.
        ArrayList<String> keyList = new ArrayList<>(hashMap.keySet());
        Collections.sort(keyList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return hashMap.get(o2).sum - hashMap.get(o1).sum;
            }
        });

        // 각 장르별 재생 횟수를 기준으로 내림차순 정렬합니다.
        for (Map.Entry entry : hashMap.entrySet()) {
            Info info = (Info) entry.getValue();

            Collections.sort(info.list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });
        }

        // 장르 별로 재생 횟수가 높은 두 개(곡이 한 개라면 하나만)의 노래의 인덱스를 리스트에 저장합니다.
        for (String key : keyList) {
            ArrayList<int[]> list = hashMap.get(key).list;

            answer.add(list.get(0)[1]);

            if (list.size() >= 2)
                answer.add(list.get(1)[1]);
        }

        return answer;
    }

    static class Info {
        int sum;
        ArrayList<int[]> list;

        public Info(int sum, ArrayList<int[]> list) {
            this.sum = sum;
            this.list = list;
        }
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] playes = {500, 600, 150, 800, 2500};

        solution(genres, playes);
    }
}
