const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `2
HPC PJVYMIY
BLMRGJIASOPZEFDCKWYHUNXQTV
FDY GAI BG UKMY
KIMHOTSQYRLCUZPAGWJNBVDXEF`
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
    const message = input().split("");
    const rule = input().split("");
    console.log(message.map((ch) => (ch === " " ? ch : rule[ch.charCodeAt(0) - "A".charCodeAt(0)])).join(""));
}
