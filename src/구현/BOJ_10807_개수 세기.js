const readline = require("readline");
const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
const input = [];

rl.on("line", (line) => {
    input.push(line);
}).on("close", () => {
    let N = input[0];
    let arr = input[1].split(" ").map(Number);
    let v = input[2];
    let cnt = Array(201).fill(0);

    for (var num of arr) cnt[num + 100]++;
    console.log(cnt[+v + 100]);
});
