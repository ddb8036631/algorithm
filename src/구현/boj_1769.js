const fs = require("fs");
let x = (process.platform === "linux" ? fs.readFileSync("/dev/stdin") : `1234567`).toString().trim().split("").map(Number);
let cnt = 0;

while (true) {
    if (x.length === 1) {
        console.log(cnt);
        console.log(x[0] % 3 === 0 ? "YES" : "NO");
        break;
    }

    const sum = x.reduce((prev, cur) => prev + cur);
    x = String(sum).split("").map(Number);
    cnt++;
}
