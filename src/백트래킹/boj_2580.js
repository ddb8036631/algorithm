const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `0 3 5 4 6 9 2 7 8
7 8 2 1 0 5 6 0 9
0 6 0 2 7 8 1 3 5
3 2 1 0 4 6 8 9 7
8 0 4 9 1 3 5 0 6
5 9 6 8 2 0 4 1 3
9 1 7 6 5 2 0 8 0
6 0 3 7 0 1 9 5 2
2 5 8 3 9 4 7 6 0`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const map = [],
    empty = [];
for (let i = 0; i < 9; i++) map.push(input().split(" ").map(Number));
for (let i = 0; i < 9; i++) {
    for (let j = 0; j < 9; j++) {
        if (!map[i][j]) empty.push([i, j]);
    }
}

dfs(0);

function dfs(idx) {
    if (idx == empty.length) {
        map.forEach((arr) => console.log(arr.join(" ")));
        process.exit(0);
    }

    const [x, y] = empty[idx];
    for (let n = 1; n <= 9; n++) {
        if (!hor(y, n) || !ver(x, n) || !rect(x, y, n)) continue;
        map[x][y] = n;
        dfs(idx + 1);
        map[x][y] = 0;
    }
}

function hor(y, n) {
    for (let i = 0; i < 9; i++) {
        if (map[i][y] == n) return false;
    }
    return true;
}

function ver(x, n) {
    for (let j = 0; j < 9; j++) {
        if (map[x][j] == n) return false;
    }
    return true;
}

function rect(x, y, n) {
    const sx = Math.floor(x / 3) * 3;
    const sy = Math.floor(y / 3) * 3;

    for (let i = sx; i < sx + 3; i++) {
        for (let j = sy; j < sy + 3; j++) {
            if (map[i][j] == n) return false;
        }
    }
    return true;
}
