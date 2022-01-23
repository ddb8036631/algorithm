const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `23 48 59
2515`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const [A, B, C] = input().split(" ").map(Number);
const D = +input();
let result = 3600 * A + 60 * B + C + D;
const h = Math.floor(result / 3600);
result -= h * 3600;
const m = Math.floor(result / 60);
const s = result % 60;

console.log(h % 24, m % 60, s % 60);
