const readline = require("readline");
const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
const input = [];

rl.on("line", (line) => {
    input.push(line);
}).on("close", () => {
    let TC = +input[0];
    let idx = 1;

    while (TC--) {
        let str = input[idx++].split(" ");
        let arr1 = str[0].split("").sort();
        let arr2 = str[1].split("").sort();

        console.log(arr1.join("") == arr2.join("") ? "Possible" : "Impossible");
    }
});
