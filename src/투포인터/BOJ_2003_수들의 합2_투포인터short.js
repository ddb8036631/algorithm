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
    sum = 0,
    cnt = 0;

while (right <= N) {
    if (sum <= M) sum += arr[right++];
    else sum -= arr[left++];

    if (sum === M) cnt++;
}

console.log(cnt);
