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
let num = 1;
arr.sort((a, b) => a - b);

for (let idx in arr) {
    if (num < arr[idx]) break;
    num += arr[idx];
}

console.log(num);
