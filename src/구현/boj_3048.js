const fs = require("fs");
const input = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `3 4
JLA
CRUO
3`
)
    .toString()
    .trim()
    .split("\n");
const g1 = input[1].split("").reverse();
const g2 = input[2].split("");
const T = +input[3];
const right = new Set(g1);
const left = new Set(g2);
const queue = [];
g1.push(...g2);

for (let t = 0; t < T; t++) {
    for (let i = 0; i < g1.length; i++) {
        if (i + 1 < g1.length && right.has(g1[i]) && left.has(g1[i + 1])) queue.push(i);
    }

    while (queue.length) {
        const idx = queue.shift();
        const tmp = g1[idx];
        g1[idx] = g1[idx + 1];
        g1[idx + 1] = tmp;
    }
}

console.log(g1.join(""));
