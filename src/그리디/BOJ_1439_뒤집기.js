const fs = require("fs");
const stdin = (process.platform === "linux" ? fs.readFileSync("/dev/stdin") : `0001100`).toString().trim().split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const str = input().split("");
let met = false;
let zeroCnt = 0,
    oneCnt = 0;

for (let i = 0; i < str.length; i++) {
    if (str[i] === "1") met = true;
    else if (met) {
        met = false;
        zeroCnt++;
    }
}
if (met) zeroCnt++;

met = false;

for (let i = 0; i < str.length; i++) {
    if (str[i] === "0") met = true;
    else if (met) {
        met = false;
        oneCnt++;
    }
}
if (met) oneCnt++;

console.log(Math.min(zeroCnt, oneCnt));
