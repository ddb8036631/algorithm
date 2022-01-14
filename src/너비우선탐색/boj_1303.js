const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `5 5
WBWWW
WWWWW
BBBBB
BBBWW
WWWWW`
)
    .toString()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const [N, M] = input().split(" ").map(Number);
const map = Array.from(Array(M));
const visit = Array.from(Array(M), () => Array(N).fill(false));
const dx = [-1, 1, 0, 0],
    dy = [0, 0, -1, 1];
let w = 0,
    b = 0;
for (let i = 0; i < M; i++) map[i] = input().split("");
for (let i = 0; i < M; i++) {
    for (let j = 0; j < N; j++) {
        if (!visit[i][j]) {
            const queue = [];
            const color = map[i][j];
            queue.push([i, j]);
            visit[i][j] = true;
            cnt = 1;
            while (queue.length) {
                const [x, y] = queue.shift();
                for (let d = 0; d < 4; d++) {
                    const nx = x + dx[d],
                        ny = y + dy[d];
                    if (nx < 0 || nx >= M || ny < 0 || ny >= N || visit[nx][ny] || map[nx][ny] !== color) continue;
                    visit[nx][ny] = true;
                    queue.push([nx, ny]);
                    cnt++;
                }
            }
            if (color === "W") w += cnt * cnt;
            else b += cnt * cnt;
        }
    }
}

console.log(w, b);
