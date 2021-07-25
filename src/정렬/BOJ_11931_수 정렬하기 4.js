const readline = require("readline");
const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
const input = [];

rl.on("line", (line) => {
    input.push(line);
}).on("close", () => {
    let arr = [];
    let answer = "";
    for (let i = 1; i < input.length; i++) arr.push(+input[i]);
    arr.sort((a, b) => b - a);
    for (let num of arr) answer += num + "\n";
    console.log(answer);
});
