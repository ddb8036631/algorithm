const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `1 10
10 10 10 10 10`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const [L, P] = input().split(" ").map(Number);
console.log(
    input()
        .split(" ")
        .map(Number)
        .map((e) => e - L * P)
        .join(" "),
);
