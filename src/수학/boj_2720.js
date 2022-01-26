const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `3
124
25
194`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
let T = +input();
while (T--) {
    let remain = +input();
    const answer = [];
    answer.push(Math.floor(remain / 25));
    remain %= 25;
    answer.push(Math.floor(remain / 10));
    remain %= 10;
    answer.push(Math.floor(remain / 5));
    remain %= 5;
    answer.push(Math.floor(remain / 1));
    console.log(answer.join(" "));
}
