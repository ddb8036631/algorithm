const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin")
    : `10 15
5 1 3 5 10 7 4 9 2 8`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const [N, S] = input().split(" ").map(Number);
const arr = input().split(" ").map(Number);
let left = 0,
    right = 0,
    sum = 0,
    answer = 100001;

while (right <= N) {
    if (sum <= S) sum += arr[right++];
    else sum -= arr[left++];

    if (sum >= S) {
        answer = Math.min(answer, right - left);
    }
}

console.log(answer == 100001 ? 0 : answer);
