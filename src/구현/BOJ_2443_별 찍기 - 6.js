const readline = require("readline");
const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
let input = [];

rl.on("line", (line) => {
    input.push(line);
}).on("close", () => {
    let N = input[0];

    for (let i = 0; i < N; i++) {
        for (let j = 1; j <= i; j++) {
            process.stdout.write(" ");
        }

        for (let j = 0; j < 2 * N - (i * 2 + 1); j++) {
            process.stdout.write("*");
        }

        process.stdout.write("\n");
    }
});
