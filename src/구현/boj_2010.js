const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `2
5
8`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const N = Number(input());
const arr = [];
for (let n = 0; n < N; n++) arr.push(Number(input()));
console.log(arr.reduce((prev, cur) => prev + cur) - arr.length + 1);
