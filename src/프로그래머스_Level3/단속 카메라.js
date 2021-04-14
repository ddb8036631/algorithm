function solution(routes) {
    let answer = 1;
    routes.sort((a, b) => a[0] - b[0]);
    let prevEnd = routes[0][1];

    for (let now in routes) {
        let start = routes[now][0],
            end = routes[now][1];

        if (start > prevEnd) {
            answer++;
            prevEnd = end;
        }

        if (end < prevEnd) {
            prevEnd = end;
        }
    }

    return answer;
}

solution([
    [-20, 15],
    [-14, -5],
    [-18, -13],
    [-5, -3],
]); // 2

solution([
    [2, 3],
    [1, 6],
    [4, 5],
]); // 2

solution([
    [4, 6],
    [1, 3],
    [2, 5],
]); // 2

solution([
    [3, 4],
    [1, 2],
    [5, 6],
]); // 3

solution([
    [1, 2],
    [3, 8],
    [4, 6],
    [5, 7],
]); // 2

solution([
    [1, 3],
    [2, 5],
    [4, 8],
    [6, 7],
]); // 3

solution([
    [1, 2],
    [2, 3],
    [3, 4],
]);
