const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `3 4 5
3 2
2 2
3 1
2 3
1 1`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const [N, M, K] = input().split(" ").map(Number);
const map = Array.from(Array(N), () => Array(M).fill(false));
const visit = Array.from(Array(N), () => Array(M).fill(false));
const dy = [-1, 1, 0, 0],
    dx = [0, 0, -1, 1];
let answer = 1;

for (let i = 0; i < K; i++) {
    const [r, c] = input().split(" ").map(Number);
    map[r - 1][c - 1] = 1;
}

for (let y = 0; y < N; y++) {
    for (let x = 0; x < M; x++) {
        if (!map[y][x] || visit[y][x]) continue;

        const q = [];
        let cnt = 0;
        visit[y][x] = true;
        q.push([y, x]);

        while (q.length) {
            const [yy, xx] = q.shift();
            cnt++;

            for (let d = 0; d < 4; d++) {
                const ny = yy + dy[d],
                    nx = xx + dx[d];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M || visit[ny][nx] || !map[ny][nx]) continue;

                visit[ny][nx] = true;
                q.push([ny, nx]);
            }
        }

        answer = Math.max(answer, cnt);
    }
}

console.log(answer);
