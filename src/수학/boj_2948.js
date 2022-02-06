const fs = require("fs");
const stdin = (process.platform === "linux" ? fs.readFileSync("/dev/stdin") : `1 1`).toString().trim().split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const month = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
const day = ["Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday"];
let [D, M] = input().split(" ").map(Number);
D += month.slice(0, M).reduce((prev, cur) => prev + cur) - 1;
console.log(day[D % 7]);
