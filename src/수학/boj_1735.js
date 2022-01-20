const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `2 7
3 5`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const [a, b] = input().split(" ").map(Number);
const [c, d] = input().split(" ").map(Number);
let e = a * d + b * c;
let f = b * d;

while (true) {
    const y = gcd(e, f);
    if (y === 1) break;
    e = Math.floor(e / y);
    f = Math.floor(f / y);
}

console.log(e, f);

function gcd(a, b) {
    return b ? gcd(b, a % b) : a;
}
