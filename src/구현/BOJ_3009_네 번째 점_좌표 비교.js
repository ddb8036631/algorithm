const readline = require("readline");
const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
const input = [];

rl.on("line", (line) => {
    input.push(line);
}).on("close", () => {
    let x1, y1, x2, y2, x3, y3;
    let l1 = input[0].split(" ");
    let l2 = input[1].split(" ");
    let l3 = input[2].split(" ");

    (x1 = l1[0]), (y1 = l1[1]);
    (x2 = l2[0]), (y2 = l2[1]);
    (x3 = l3[0]), (y3 = l3[1]);

    if (x1 == x2) process.stdout.write(x3 + " ");
    else if (x1 == x3) process.stdout.write(x2 + " ");
    else process.stdout.write(x1 + " ");

    if (y1 == y2) console.log(y3);
    else if (y1 == y3) console.log(y2);
    else console.log(y1);
});
