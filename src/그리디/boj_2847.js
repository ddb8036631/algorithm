const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `4
5
3
7
5`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const arr = [];
let N = +input();
while (N--) {
    arr.push(+input());
}
let answer = 0;
for (let i = arr.length - 1; i >= 0; i--) {
    if (arr[i] > arr[i + 1] - 1) {
        answer += arr[i] - arr[i + 1] + 1;
        arr[i] = arr[i + 1] - 1;
    }
}

console.log(answer);
