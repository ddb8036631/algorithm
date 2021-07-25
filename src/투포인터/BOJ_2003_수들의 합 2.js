const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin")
    : `10 5
1 2 3 4 2 5 3 1 1 2`
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
let left = 0,
    right = 0,
    cnt = 0;

while (left < N && right < N) {
    let sum = arr[left];

    while (sum < M) {
        sum += arr[++right];
    }

    if (sum == M) {
        cnt++;
    }

    left = right = left + 1;
    sum = 0;
}

console.log(cnt);
