const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin")
    : `3
5 1 2`
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
let made = Array(2000001).fill(false);
let num = 1;

dfs(0, 0);

while (true) {
    if (made[num]) {
        num++;
        continue;
    }

    console.log(num);
    break;
}

function dfs(idx, sum) {
    if (idx == N) {
        made[sum] = true;
        return;
    }

    dfs(idx + 1, sum);
    dfs(idx + 1, sum + arr[idx]);
}
