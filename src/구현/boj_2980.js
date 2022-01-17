const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `4 30
7 13 5
14 4 4
15 3 10
25 1 1`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const [N, L] = input().split(" ").map(Number);
const map = {};
const check = Array.from(L).fill(false);
for (let i = 0; i < N; i++) {
    const [D, R, G] = input().split(" ").map(Number);
    map[D] = [R, G];
    check[D] = true;
}
let time = 0,
    idx = 0;
while (true) {
    if (idx === L) break;
    if (check[idx]) {
        const [R, G] = map[idx];
        const remain = time % (R + G);
        if (remain > R) time++;
        else time += R - remain + 1;
        idx++;
    } else {
        idx++;
        time++;
    }
}

console.log(time);
