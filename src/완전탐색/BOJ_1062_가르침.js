const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin")
    : `3 6
antarctica
antahellotica
antacartica`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

let [N, K] = input().split(" ").map(Number);
let base = 0b10000010000100000101;
let words = [];
let answer = 0;

for (let i = 0; i < N; i++) {
    let s = input();
    let tmp = base;

    for (let i = 4; i < s.length - 4; i++) {
        let idx = s.charAt(i).charCodeAt(0) - "a".charCodeAt(0);
        tmp |= 1 << idx;
    }

    words.push(tmp);
}

comb(0, 5, base);

console.log(answer);

function comb(idx, cnt, learned) {
    if (cnt == K) {
        check(learned);

        return;
    }

    if (idx == 26) return;

    comb(idx + 1, cnt, learned);

    if ((learned & (1 << idx)) == 0) comb(idx + 1, cnt + 1, learned | (1 << idx));
}

function check(learned) {
    let cnt = 0;

    for (let i = 0; i < N; i++) if ((words[i] & learned) == words[i]) cnt++;

    answer = Math.max(answer, cnt);
}
