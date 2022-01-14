const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `3
10 11 3
0 1 0 1`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const N = Number(input());
const arr = input().split(" ").map(Number);
const cnt = input().split(" ").map(Number);
let max = Number.MIN_SAFE_INTEGER,
    min = Number.MAX_SAFE_INTEGER;

dfs(1, arr[0]);
console.log(max);
console.log(min);

function dfs(idx, sum) {
    if (idx === N) {
        max = Math.max(max, sum);
        min = Math.min(min, sum);
        return;
    }

    for (let i = 0; i < 4; i++) {
        if (cnt[i]) {
            cnt[i]--;
            switch (i) {
                case 0:
                    dfs(idx + 1, sum + arr[idx]);
                    break;
                case 1:
                    dfs(idx + 1, sum - arr[idx]);
                    break;
                case 2:
                    dfs(idx + 1, sum * arr[idx]);
                    break;
                case 3:
                    dfs(idx + 1, ~~(sum / arr[idx]));
                    break;
            }
            cnt[i]++;
        }
    }
}
