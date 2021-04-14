const readline = require("readline");
const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
let input = [];

rl.on("line", function (line) {
    input.push(line);
}).on("close", function () {
    let N = Number(input[0]);
    let numbers = [];
    let regex = /[\d]+/g;

    for (let i = 1; i < input.length; i++) {
        let str = input[i];

        str.match(regex).forEach((num) => {
            num = num.replace(/^0+/, "");
            numbers.push(num.length == 0 ? "0" : num);
        });
    }

    numbers.sort((a, b) => {
        return a.length == b.length ? a - b : a.length - b.length;
    });

    numbers.forEach((num) => console.log(num));
    process.exit();
});
