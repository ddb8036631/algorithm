const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `4
FFLF
FFRRFF
FFFBBBRFFFBBB
FLFRFLBRBLB`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const T = Number(input());
const dx = [1, 0, -1, 0],
    dy = [0, 1, 0, -1];
let x, y, dir, ul, dl, ll, rl;
const answer = [];

for (let i = 0; i < T; i++) {
    const command = input();
    x = y = dir = ul = dl = ll = rl = 0;

    for (ch of command) {
        switch (ch) {
            case "F":
                x += dx[dir];
                y += dy[dir];
                break;
            case "B":
                x -= dx[dir];
                y -= dy[dir];
                break;
            case "L":
                dir = (dir + 3) % 4;
                break;
            case "R":
                dir = (dir + 1) % 4;
                break;
        }
        ul = Math.max(ul, x);
        dl = Math.min(dl, x);
        rl = Math.max(rl, y);
        ll = Math.min(ll, y);
    }
    answer.push((ul - dl) * (rl - ll));
}

console.log(answer.join("\n"));
