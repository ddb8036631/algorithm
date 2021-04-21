const readline = require("readline");
const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
const input = [];

rl.on("line", (line) => {
    input.push(line);
}).on("close", () => {
    let hor = new Map(),
        ver = new Map();

    for (let i = 0; i < input.length; i++) {
        let pos = input[i].split(" ");
        hor.set(pos[0], (hor.get(pos[0]) ?? 0) + 1);
        ver.set(pos[1], (ver.get(pos[1]) ?? 0) + 1);
    }

    hor.forEach((val, key) => {
        if (val == 1) process.stdout.write(key + " ");
    });

    ver.forEach((val, key) => {
        if (val == 1) console.log(key);
    });
});
