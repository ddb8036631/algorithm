const solution = (n, times) => {
    const MAX = times.sort((a, b) => b - a)[0] * n;
    let low = 1,
        high = MAX;

    while (low <= high) {
        let mid = parseInt((low + high) / 2);
        let cnt = 0;

        for (let time of times) cnt += parseInt(mid / time);

        if (cnt >= n) {
            answer = mid;
            high = mid - 1;
        } else low = mid + 1;
    }

    return answer;
};

console.log(solution(6, [7, 10]));
