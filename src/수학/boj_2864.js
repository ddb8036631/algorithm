const fs = require("fs");
const stdin = (process.platform === "linux" ? fs.readFileSync("/dev/stdin") : `11 25`).toString().trim().split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
let [A, B] = input().split(" ");
const answer = [];

A = A.replace(/6/g, 5);
B = B.replace(/6/g, 5);
answer.push(+A + +B);

A = A.replace(/5/g, 6);
B = B.replace(/5/g, 6);
answer.push(+A + +B);

console.log(answer.join(" "));
