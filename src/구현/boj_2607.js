const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `4
DOG
GOD
GOOD
DOLL`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const N = +input();
const words = [];
const target = Array(26).fill(0);
let answer = 0;

for (let i = 0; i < N; i++) words.push(input());
for (const ch of words[0]) target[ch.charCodeAt(0) - "A".charCodeAt(0)]++;
for (let i = 1; i < N; i++) {
    const now = Array(26).fill(0);
    let sum = 0;

    for (const ch of words[i]) now[ch.charCodeAt(0) - "A".charCodeAt(0)]++;
    for (let i = 0; i < 26; i++) sum += Math.abs(target[i] - now[i]);

    if (words[0].length === words[i].length && sum <= 2) answer++;
    else if (words[0].length !== words[i].length && sum <= 1) answer++;
}

console.log(answer);
