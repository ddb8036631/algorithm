const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `3 3
1 0 2
0 0 0
3 0 0
2 3 2`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const [N, K] = input().split(" ").map(Number);
const map = Array.from(Array(N), () => Array(N).fill(0));
for (let i = 0; i < N; i++) map[i] = input().split(" ").map(Number);
const visit = Array.from(Array(N), () => Array(N).fill(false));
const [S, X, Y] = input().split(" ").map(Number);
const virus = Array(K + 1);
const dx = [-1, 1, 0, 0],
    dy = [0, 0, -1, 1];

for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
        if (!map[i][j]) continue;
        if (!virus[map[i][j]]) virus[map[i][j]] = [];

        visit[i][j] = true;
        virus[map[i][j]].push({ x: i, y: j });
    }
}

for (let s = 0; s < S; s++) {
    for (let v = 1; v <= K; v++) {
        let tmp = [];

        while (virus[v]?.length) {
            let now = virus[v].shift();

            for (let d = 0; d < 4; d++) {
                let nx = now.x + dx[d],
                    ny = now.y + dy[d];

                if (!inRange(nx, ny)) continue;

                if (!visit[nx][ny] && !map[nx][ny]) {
                    visit[nx][ny] = true;
                    map[nx][ny] = v;
                    tmp.push({ x: nx, y: ny });
                }
            }
        }

        virus[v] = tmp;
    }
}

console.log(map[X - 1][Y - 1]);

function inRange(x, y) {
    return x >= 0 && x < N && y >= 0 && y < N;
}
