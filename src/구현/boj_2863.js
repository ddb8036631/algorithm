const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `1 2
3 4`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const [A, B] = input().split(" ").map(Number);
const [C, D] = input().split(" ").map(Number);
let answer = 0,
    max = A / C + B / D;

if (C / D + A / B > max) {
    answer = 1;
    max = C / D + A / B;
}
if (D / B + C / A > max) {
    answer = 2;
    max = D / B + C / A;
}
if (B / A + D / C > max) {
    answer = 3;
}

console.log(answer);
