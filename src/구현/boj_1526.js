const fs = require("fs");
let N = Number((process.platform === "linux" ? fs.readFileSync("/dev/stdin") : `474747`).toString().trim());
const set = new Set([4, 7]);

while (true) {
    let found = true;
    for (const ch of String(N)) {
        if (!set.has(Number(ch))) {
            found = false;
            break;
        }
    }
    if (found) break;
    N--;
}

console.log(N);
