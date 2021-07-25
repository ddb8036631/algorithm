const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `7
35 40 50 10 30 45 60
2`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const N = +input();
const arr = input().split(" ").map(Number);
const K = +input();
const sum = Array(N + 1).fill(0);
const dp = Array.from(Array(4), () => Array(N + 1).fill(0));

for (let i = 1; i <= N; i++) sum[i] = sum[i - 1] + arr[i - 1];

for (let cnt = 1; cnt <= 3; cnt++) {
    for (let idx = cnt * K; idx <= N; idx++) {
        dp[cnt][idx] = Math.max(dp[cnt][idx - 1], dp[cnt - 1][idx - K] + sum[idx] - sum[idx - K]);
    }
}

console.log(dp[3][N]);
