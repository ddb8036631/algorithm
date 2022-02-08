const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `1
13`
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
    const n = +input();
    console.log(
        n
            .toString(2)
            .split("")
            .reverse()
            .map((v, i) => (v == "1" ? i : -1))
            .filter((v) => v != -1)
            .sort((a, b) => a - b)
            .join(" "),
    );
}
