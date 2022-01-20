const fs = require("fs");
const stdin = (process.platform === "linux" ? fs.readFileSync("/dev/stdin") : `contest`).toString().trim().split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const word = input();
const sosu = Array(1041).fill(true);
let sum = 0;

for (const ch of word) {
    const ascii = ch.charCodeAt(0);

    if (ascii <= "Z".charCodeAt(0)) {
        sum += 27 + ascii - +"A".charCodeAt(0);
    } else {
        sum += 1 + ascii - "a".charCodeAt(0);
    }
}

for (let i = 2; i <= Math.sqrt(sum); i++) {
    if (!sosu[i]) continue;
    for (let j = i + i; j <= sum; j += i) {
        sosu[j] = false;
    }
}

console.log(`It is ${sosu[sum] ? "" : "not "}a prime word.`);
