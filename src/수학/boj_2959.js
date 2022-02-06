const fs = require("fs");
const stdin = (process.platform === "linux" ? fs.readFileSync("/dev/stdin") : `1 2 3 4`).toString().trim().split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const arr = input()
    .split(" ")
    .map(Number)
    .sort((a, b) => a - b);
console.log(arr[0] * arr[2]);
