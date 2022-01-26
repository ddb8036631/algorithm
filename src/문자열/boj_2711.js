const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `4
4 MISSPELL
1 PROGRAMMING
7 CONTEST
3 BALLOON`
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
    const [i, s] = input().split(" ");
    console.log(s.substring(0, +i - 1) + s.substring(+i));
}
