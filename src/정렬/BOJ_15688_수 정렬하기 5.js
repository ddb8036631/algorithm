const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `5
    1
    2
    3
    4
    5`
).split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

let N = +input();
let arr = [];
let answer = "";

while (N--) arr.push(+input());
arr.sort((a, b) => a - b);

for (let num of arr) answer += num + "\n";

console.log(answer);
