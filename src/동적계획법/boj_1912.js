const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");
const N = +input[0];
const arr = input[1].split(" ").map(Number);
const dp = Array(N);
let answer = arr[0];
dp[0] = arr[0];

for (let i = 1; i < N; i++) {
    dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
    answer = Math.max(answer, dp[i]);
}

console.log(answer);
