const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `2
11
1 2 2 2 3 3 1 1 1 3 3`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const N = +input();
const K = +input();
const arr = input().split(" ").map(Number);
const SIZE = 101;
let recommandCnt = Array(SIZE).fill(0),
    time = Array(SIZE).fill(0),
    candidate = 0;
let now = 0;

for (let num of arr) {
    now++;

    if (candidate === N) {
        if (recommandCnt[num]) {
            recommandCnt[num]++;

            continue;
        }

        let idx = -1;
        let cnt = Number.MAX_VALUE;

        for (let i = 1; i < SIZE; i++) {
            if (!recommandCnt[i]) continue;

            if (recommandCnt[i] == cnt) {
                idx = time[idx] > time[i] ? i : idx;
            } else if (recommandCnt[i] < cnt) {
                cnt = recommandCnt[i];
                idx = i;
            }
        }

        recommandCnt[idx] = time[idx] = 0;
        recommandCnt[num] = 1;
        time[num] = now;
    } else {
        if (recommandCnt[num]) {
            recommandCnt[num]++;

            continue;
        }

        recommandCnt[num]++;
        time[num] = now;
        candidate++;
    }
}

let answer = "";
for (let num = 1; num < SIZE; num++) if (recommandCnt[num]) answer += num + " ";
console.log(answer);
