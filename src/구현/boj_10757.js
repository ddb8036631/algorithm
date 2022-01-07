const readline = require("readline");
const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
const input = [];

rl.on("line", (line) => {
    input.push(line);
}).on("close", () => {
    const [a, b] = input[0].split(" ");
    let len_a = a.length,
        len_b = b.length;
    let aa = 0,
        bb = 0,
        carry = 0;
    const answer = [];
    while (len_a || len_b || carry) {
        if (len_a) aa = Number(a[len_a-- - 1]);
        if (len_b) bb = Number(b[len_b-- - 1]);
        answer.push((aa + bb + carry) % 10);
        carry = aa + bb + carry > 9 ? 1 : 0;
        aa = bb = 0;
    }

    console.log(answer.reverse().join(""));
});
