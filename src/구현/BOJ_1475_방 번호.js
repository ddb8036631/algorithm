const readline = require("readline");
const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
const input = [];

rl.on("line", (line) => {
    input.push(line);
}).on("close", () => {
    let num = input[0].split("").map((e) => +e);
    let cnt = Array(10).fill(0);

    for (let n of num) {
        if (n === 6) {
            if (cnt[n] > cnt[9]) cnt[9]++;
            else cnt[n]++;
        } else if (n === 9) {
            if (cnt[n] > cnt[6]) cnt[6]++;
            else cnt[n]++;
        } else cnt[n]++;
    }

    let answer = 0;
    for (let c of cnt) answer = Math.max(answer, c);

    console.log(answer);
});
