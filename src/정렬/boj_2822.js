const fs = require("fs");
const stdin = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const arr = [];
for (let i = 1; i <= 8; i++) {
    arr.push([+input(), i]);
}

const target = arr.sort((a, b) => a[0] - b[0]).slice(3);
console.log(target.reduce((acc, cur) => acc + cur[0], 0));
console.log(
    target
        .map((v) => v[1])
        .sort((a, b) => a - b)
        .join(" "),
);
