const fs = require("fs");
const stdin =
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `15 15
2 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
1 1 1 1 1 1 1 1 1 1 0 1 0 0 0
1 1 1 1 1 1 1 1 1 1 0 1 1 1 1`
              .trim()
              .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const [n, m] = input().split(" ").map(Number);
const map = [];
const visit = Array.from(Array(n), () => Array(m).fill(false));
const dist = Array.from(Array(n), () => Array(m).fill(0));
const d = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1],
];
const queue = [];
let sx = 0,
    sy = 0;
let answer = "";

for (let i = 0; i < n; i++) {
    map.push(input().split(" ").map(Number));
    for (let j = 0; j < m; j++) {
        if (map[i][j] === 2) {
            (sx = i), (sy = j);
            queue.push([sx, sy]);
            visit[sx][sy] = true;
        }
    }
}

while (queue.length) {
    const [x, y] = queue.shift();
    for ([dx, dy] of d) {
        const nx = x + dx,
            ny = y + dy;
        if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || !map[nx][ny]) continue;
        visit[nx][ny] = true;
        queue.push([nx, ny]);
        dist[nx][ny] = dist[x][y] + 1;
    }
}

for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
        answer += (map[i][j] === 1 && !dist[i][j] ? -1 : dist[i][j]) + " ";
    }
    answer += "\n";
}
console.log(answer);
