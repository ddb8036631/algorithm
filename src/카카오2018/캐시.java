package 카카오2018;

import java.util.LinkedList;

public class 캐시 {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LinkedList<String> cache = new LinkedList<>();

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            if (cache.contains(city.toUpperCase())) {
                answer += 1;
                cache.remove(cache.indexOf(city.toUpperCase()));

            } else {
                answer += 5;

                if (cache.size() == cacheSize)
                    cache.remove(0);
            }

            cache.addLast(city.toUpperCase());
        }

        return answer;
    }

    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

//        int cacheSize = 3;
//        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

//        int cacheSize = 2;
//        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

//        int cacheSize = 5;
//        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

//        int cacheSize = 2;
//        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};

//        int cacheSize = 0;
//        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        solution(cacheSize, cities);
    }
}
