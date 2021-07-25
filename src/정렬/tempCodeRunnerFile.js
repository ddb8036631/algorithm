const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `2
AA1
A1A`
).split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

let N = +input();
let arr = [];
let answer = "";

while (N--) arr.push(input());

arr.sort((a, b) => {
    if (a.length != b.length) return a.length - b.length;
    else {
        let sum1 = 0,
            sum2 = 0;

        for (let idx in a) {
            if (!isNaN(Number(a[idx]))) sum1 += +a[idx];
            if (!isNaN(Number(b[idx]))) sum2 += +b[idx];
        }

        if (sum1 == sum2) {
            return a < b ? -1 : 1;
        }

        return sum1 - sum2;
    }
});

for (let str of arr) answer += str + "\n";
console.log(answer);
