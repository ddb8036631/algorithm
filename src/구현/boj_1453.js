const fs = require("fs");
const input = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `3
1 2 3`
)
    .toString()
    .trim()
    .split("\n");
const N = Number(input[0]);
const seq = input[1].split(" ").map(Number);
const seat = Array(101).fill(false);
let answer = 0;

for (s of seq) {
    if (seat[s]) answer++;
    else seat[s] = true;
}

console.log(answer);
