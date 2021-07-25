const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin")
    : `7 3
1 2 3 4 5 6 7
1 2 3`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const [N, M] = input().split(" ").map(Number);
const A = input().split(" ").map(Number);
const B = input().split(" ").map(Number);
let remain = Array(7).fill(false);
let remainCnt = 0;

for (let num of A) {
    let matchingIdx = num % 7;

    if (!remain[matchingIdx]) {
        remain[matchingIdx] = true;
        remainCnt++;
    }
}

let sum = 0;

for (let num of B) {
    sum += num;
    let target = (7 - (sum % 7)) % 7;

    if (!remain[target]) continue;
    if (remainCnt == 1) {
        sum -= num;
        continue;
    }

    remain[target] = false;
    remainCnt--;
}

let answer = [];

for (let num of A) {
    let matchingIdx = num % 7;

    if (remain[matchingIdx]) {
        answer.push((num + sum) % (1e9 + 7));
    }
}

console.log(answer.length);
console.log(answer.join(" "));
