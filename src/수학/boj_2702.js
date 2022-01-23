const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `3
5 10
7 23
42 56`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
let T = +input();

while (T--) {
    const [a, b] = input().split(" ").map(Number);
    const gcd = GCD(Math.max(a, b), Math.min(a, b));
    console.log(Math.floor((a * b) / gcd), gcd);
}

function GCD(a, b) {
    return b === 0 ? a : GCD(b, a % b);
}
