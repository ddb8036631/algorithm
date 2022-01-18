const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `2 4
1 2
3 4
1 1 1 1
1 2 1 2
2 1 2 1
2 2 2 2`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const [N, M] = input().split(" ").map(Number);
const dp = Array.from(Array(N + 1), () => Array(N + 1).fill(0));
const answer = [];

for (let i = 1; i <= N; i++) {
    const arr = input().split(" ").map(Number);
    for (let j = 1; j <= N; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + arr[j - 1] - dp[i - 1][j - 1];
    }
}

for (let n = 0; n < M; n++) {
    const [x1, y1, x2, y2] = input().split(" ").map(Number);
    answer.push(dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]);
}

console.log(answer.join("\n"));
