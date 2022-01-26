const fs = require("fs");
const stdin = (process.platform === "linux" ? fs.readFileSync("/dev/stdin") : `ZZZZZ 36`).toString().trim().split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const [N, B] = input().split(" ");

console.log(
    N.split("")
        .reverse()
        .map((e) => (e.charCodeAt(0) >= "A".charCodeAt(0) ? e.charCodeAt(0) - "A".charCodeAt(0) + 10 : e))
        .reduce((p, c, i) => p + +c * (+B) ** i, 0),
);
