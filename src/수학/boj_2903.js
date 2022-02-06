const fs = require("fs");
const stdin = (process.platform === "linux" ? fs.readFileSync("/dev/stdin") : `1`).toString().trim().split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const N = +input();
let w = 2;
for (let i = 1; i <= N; i++) w += w - 1;
console.log(w ** 2);
