const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `3
7 5 5 4 9
1 1 1 1 1
2 3 3 2 10`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const N = +input();
let max = 0;
let answer = 0;

for (let n = 1; n <= N; n++) {
    const arr = input().split(" ").map(Number);
    for (let i = 0; i < arr.length - 2; i++) {
        for (let j = i + 1; j < arr.length - 1; j++) {
            for (let k = j + 1; k < arr.length; k++) {
                const remain = (arr[i] + arr[j] + arr[k]) % 10;
                if (remain >= max) {
                    max = remain;
                    answer = n;
                }
            }
        }
    }
}

console.log(answer);
