const readline = require("readline");
const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
const input = [];

rl.on("line", (line) => {
    input.push(line);
}).on("close", () => {
    let S = input[0].split("");
    let cnt = Array(26).fill(0);

    for (var ch of S) {
        let idx = ch.charCodeAt(0) - "a".charCodeAt(0);
        cnt[idx]++;
    }

    // console.log(cnt.join(" "));
    cnt.forEach((e) => process.stdout.write(e + " "));
    // process.stdout.write("\n");
});
