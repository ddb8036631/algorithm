const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `1ovey0uS2
veS`
)
    .toString()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
let S = input();
const K = input();
S = S.replace(/[0-9]/g, "");
console.log(S.includes(K) ? 1 : 0);
