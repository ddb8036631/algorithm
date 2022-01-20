const fs = require("fs");
const N = Number((process.platform === "linux" ? fs.readFileSync("/dev/stdin") : `3`).toString().trim());
const dp = Array(N + 1).fill(0);
const MOD = 45678;
dp[1] = 5;

for (let i = 2; i <= N; i++) {
    dp[i] = (dp[i - 1] + (i + 1) * 5 - 5 - (2 * i - 1)) % MOD;
}

console.log(dp[N]);
