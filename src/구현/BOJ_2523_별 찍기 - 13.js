const readline = require("readline");
const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
let input = [];

rl.on("line", (line) => {
    input.push(line);
}).on("close", () => {
    for (let i = 1; i <= input[0]; i++) {
        for (let j = 1; j <= i; j++) {
            process.stdout.write("*");
        }
        console.log();
    }
    for (let i = input[0] - 1; i >= 1; i--) {
        for (let j = 1; j <= i; j++) {
            process.stdout.write("*");
        }
        process.stdout.write("\n");
    }
});
