const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `90
###.....###.#..####.#.......#.#....####.....###.#....##.#.......#.#....####.....###.#....#`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const N = Number(input());
const signal = input().replace(/#/g, 1).replace(/\./g, 0);
const map = [];
const answer = [];
let delta = Math.floor(N / 5);
for (let i = 0; i < 5; i++) {
    const sub = signal.substring(i * delta, (i + 1) * delta);
    map.push(sub.split("").map(Number));
}

for (let i = 0; i < N; i++) {
    if (!map[0][i]) continue;

    const result = check(i);
    answer.push(result);
    if (result !== 1) i += 2;
}

console.log(answer.join(""));

function check(y) {
    if (map[1][y] && map[2][y] && map[3][y] && map[4][y] && (y + 1 === N || (!map[1][y + 1] && !map[2][y + 1] && !map[3][y + 1] && !map[4][y + 1]))) return 1;
    if (!map[1][y + 1] && !map[2][y + 1] && !map[3][y + 1] && map[1][y]) return 0;
    if (!map[1][y] && !map[1][y + 1] && map[3][y]) return 2;
    if (!map[1][y] && !map[1][y + 1] && map[2][y]) return 3;
    if (!map[0][y + 1] && !map[1][y + 1]) return 4;
    if (!map[1][y + 1] && !map[1][y + 2] && !map[3][y] && !map[3][y + 1]) return 5;
    if (!map[1][y + 1] && !map[1][y + 2] && !map[3][y + 1]) return 6;
    if (!map[1][y]) return 7;
    if (!map[1][y + 1] && map[3][y] && !map[3][y + 1]) return 8;
    return 9;
}
