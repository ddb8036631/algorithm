const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `2
5
50 10 100 20 40
30 50 70 10 60
7
10 30 10 50 100 20 40
20 40 30 50 60 20 80`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const T = +input();
for (let t = 0; t < T; t++) {
    const n = +input();
    const arr = [];
    const dp = Array.from(Array(2), () => Array(n + 1).fill(0));
    arr.push([0, ...input().split(" ").map(Number)], [0, ...input().split(" ").map(Number)]);
    dp[0][1] = arr[0][1];
    dp[1][1] = arr[1][1];

    for (let j = 2; j <= n; j++) {
        dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + arr[0][j];
        dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + arr[1][j];
    }

    console.log(Math.max(dp[0][n], dp[1][n]));
}
