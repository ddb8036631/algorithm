const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `7
3 1 6 2 7 30 1`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const N = +input();
const arr = input()
    .split(" ")
    .map(Number)
    .sort((a, b) => a - b);
let num = 1;

for (let i = 0; i < N; i++) {
    if (num < arr[i]) break;
    num += arr[i];
}

console.log(num);
