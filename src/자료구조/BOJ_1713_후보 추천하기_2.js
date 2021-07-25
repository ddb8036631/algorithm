const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `3
14
2 1 4 3 5 6 2 7 2 100 100 54 54 50`
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
const candidates = new Map();

// for (let idx in arr) {
//     let num = arr[idx];
for (let i = 0; i < K; i++) {
    let num = arr[i];

    if (candidates.has(num)) {
        candidates.get(num)[0]++;
    } else {
        if (candidates.size === N) {
            let min = null;

            for ([key, value] of candidates.entries()) {
                if (!min) {
                    min = [key, value];
                    continue;
                }

                const [minCnt, minTime] = min[1];
                const [nowCnt, nowTime] = value;

                if (nowCnt < minCnt || (nowCnt === minCnt && nowTime < minTime)) {
                    min = [key, value];
                }
            }

            candidates.delete(min[0]);
        }

        // candidates.set(num, [1, idx]);
        candidates.set(num, [1, i]);
    }
}

let answer = "";
[...candidates.keys()].sort((a, b) => a - b).forEach((candidate) => (answer += candidate + " "));
console.log(answer);
