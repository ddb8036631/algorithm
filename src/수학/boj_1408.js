const fs = require("fs");
const input = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `13:52:30
14:00:00`
)
    .toString()
    .trim()
    .split("\n");
const now = input[0].split(":").map(Number);
const start = input[1].split(":").map(Number);
const answer = Array(3);

start[0] += 24;
if (start[2] < now[2]) {
    start[2] += 60;
    start[1] -= 1;
}
if (start[1] < now[1]) {
    start[1] += 60;
    start[0] -= 1;
}

answer[2] = ("00" + (start[2] - now[2])).slice(-2);
answer[1] = ("00" + (start[1] - now[1])).slice(-2);
answer[0] = ("00" + ((start[0] - now[0]) % 24)).slice(-2);
console.log(answer.join(":"));
