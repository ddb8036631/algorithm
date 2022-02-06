const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `2 3 4 5
4 9 5`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const [A, B, C, D] = input().split(" ").map(Number);
const arrival = input().split(" ").map(Number);
const answer = [0, 0, 0];
arrival.forEach((v, i) => {
    if (0 < v % (A + B) && v % (A + B) <= A) answer[i]++;
    if (0 < v % (C + D) && v % (C + D) <= C) answer[i]++;
});
console.log(answer.join("\n"));
