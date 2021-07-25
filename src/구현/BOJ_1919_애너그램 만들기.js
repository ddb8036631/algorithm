const readline = require("readline");
const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
const input = [];

rl.on("line", (line) => {
    input.push(line);
}).on("close", () => {
    let S1 = input[0],
        S2 = input[1];

    let cnt1 = Array(26).fill(0);
    let cnt2 = Array(26).fill(0);

    for (let ch of S1) cnt1[ch.charCodeAt(0) - "a".charCodeAt(0)]++;
    for (let ch of S2) cnt2[ch.charCodeAt(0) - "a".charCodeAt(0)]++;

    let answer = 0;
    for (let idx in cnt1) {
        if (cnt1[idx] == cnt2[idx]) continue;

        if (cnt1[idx] > cnt2[idx]) answer += cnt1[idx] - cnt2[idx];
        else answer += cnt2[idx] - cnt1[idx];
    }

    console.log(answer);
});
