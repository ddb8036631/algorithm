const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `3 3
1 1 1
2 2 2
0 1 0
3 3 3
4 4 4
5 5 100`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const [N, M] = input().split(" ").map(Number);
const A = [];
const B = [];

for (let i = 0; i < N; i++) A.push(input().split(" ").map(Number));
for (let i = 0; i < N; i++) B.push(input().split(" ").map(Number));

for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
        A[i][j] += B[i][j];
    }
}

console.log(A.map((arr) => arr.join(" ")).join("\n"));
