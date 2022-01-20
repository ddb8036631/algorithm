const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `673
51
1000
99
0`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

while (true) {
    let N = input();
    if (Number(N) === 0) break;

    while (N.length > 1) {
        const tmp = N.split("").map(Number);
        N = String(tmp.reduce((prev, curr) => prev + curr));
    }

    console.log(N);
}
