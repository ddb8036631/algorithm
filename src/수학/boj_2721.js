const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `4
3
4
5
10`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const T = Array(302).fill(0);
const W = Array(301).fill(0);
let TC = +input();
for (let i = 1; i < T.length; i++) T[i] = T[i - 1] + i;
for (let i = 1; i < W.length; i++) W[i] = W[i - 1] + i * T[i + 1];
while (TC--) console.log(W[+input()]);
