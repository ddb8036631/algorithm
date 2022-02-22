const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");
const N = +input[0];
const arr = input[1].split(" ").map(Number);
const dp = Array(N);

for (let i = 0; i < N; i++) {
    dp[i] = 1;
    for (let j = 0; j < i; j++) {
        if (arr[i] < arr[j] && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;
    }
}

console.log(Math.max(...dp));
