const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `2
7
122`
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
    const set = new Set();
    input()
        .split("")
        .forEach((v) => set.add(v));
    console.log(set.size);
}
