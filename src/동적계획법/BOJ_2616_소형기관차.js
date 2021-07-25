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
let sum = Array(N + 1).fill(0);
let dp = Array.from(Array(N + 1), () => Array(3).fill(-1));

for (let i = 1; i <= N; i++) sum[i] = sum[i - 1] + arr[i - 1];

console.log(go(1, 0));

function go(idx, cnt) {
    if (cnt === 3) return 0;
    if (idx >= N) return 0;
    if (dp[idx][cnt] != -1) return dp[idx][cnt];
    if (idx + K - 1 <= N) dp[idx][cnt] = Math.max(go(idx + 1, cnt), sum[idx + K - 1] - sum[idx - 1] + go(idx + K, cnt + 1));

    return dp[idx][cnt];
}
