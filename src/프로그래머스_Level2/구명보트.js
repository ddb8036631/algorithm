function solution(people, limit) {
    let answer = 0;
    let low = 0,
        high = people.length - 1;
    people.sort((a, b) => a - b);

    while (low <= high) {
        if (people[low] + people[high] <= limit) {
            low++;
            high--;
        } else {
            high--;
        }

        answer++;
    }

    return answer;
}

solution([70, 50, 80, 50], 100);
solution([70, 80, 50], 100);
solution([40, 50, 60, 70, 80, 90, 100, 110], 200);
solution([240], 240);
