const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin")
    : `4 2
1 1 1 1`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const [N, M] = input().split(" ").map(Number);
const arr = input().split(" ").map(Number);
let cnt = 0;

for (let i = 0; i < N; i++) {
    let sum = 0;

    for (let j = i; j < N; j++) {
        sum += arr[j];

        if (sum == M) {
            cnt++;
            break;
        } else if (sum > M) break;
    }
}

console.log(cnt);
