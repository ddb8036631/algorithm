const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `2
ABC-0123
AAA-9999`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const N = Number(input());
for (let n = 0; n < N; n++) {
    const [front, back] = input().split("-");
    let sum = 0;
    for (let i = front.length - 1; i >= 0; i--) {
        sum += (front.charCodeAt(i) - "A".charCodeAt(0)) * Math.pow(26, front.length - i - 1);
    }
    console.log(Math.abs(sum - Number(back)) <= 100 ? "nice" : "not nice");
}
