const fs = require("fs");
const [S1, S2, S3] = (process.platform === "linux" ? fs.readFileSync("/dev/stdin") : `3 2 3`).toString().trim().split(" ").map(Number);
const cnt = Array(81).fill(0);
let maxCnt = 0,
    answer = 0;

for (let i = 1; i <= S1; i++) {
    for (let j = 1; j <= S2; j++) {
        for (let k = 1; k <= S3; k++) {
            cnt[i + j + k]++;
        }
    }
}

for (let sum = 1; sum <= 80; sum++) {
    if (cnt[sum] > maxCnt) {
        maxCnt = cnt[sum];
        answer = sum;
    }
}

console.log(answer);
