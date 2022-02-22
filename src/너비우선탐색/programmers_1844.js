function solution(maps) {
    const n = maps.length,
        m = maps[0].length;
    const dx = [-1, 1, 0, 0],
        dy = [0, 0, -1, 1];
    const visit = Array.from(Array(n), () => Array(m).fill(false));
    const q = [];

    visit[0][0] = true;
    q.push([0, 0, 1]);

    while (q.length) {
        const [x, y, cnt] = q.shift();

        if (x == n - 1 && y == m - 1) return cnt;

        for (let d = 0; d < 4; d++) {
            const nx = x + dx[d],
                ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || !maps[nx][ny]) continue;

            visit[nx][ny] = true;
            q.push([nx, ny, cnt + 1]);
        }
    }

    return -1;
}

console.log(
    solution([
        [1, 0, 1, 1, 1],
        [1, 0, 1, 0, 1],
        [1, 0, 1, 1, 1],
        [1, 1, 1, 0, 1],
        [0, 0, 0, 0, 1],
    ]),
);
console.log(
    solution([
        [1, 0, 1, 1, 1],
        [1, 0, 1, 0, 1],
        [1, 0, 1, 1, 1],
        [1, 1, 1, 0, 0],
        [0, 0, 0, 0, 1],
    ]),
);
