const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `47-FBI
BOND-007
RF-FBI18
MARICA-13
13A-FBILL`
).split("\n");

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

let idx = 0;
let answer = [];
let regex = /FBI/g;

while (idx++ < 5) {
    let str = input();
    if (str.search(regex) != -1) answer.push(idx);
}

console.log(answer.length == 0 ? "HE GOT AWAY!" : answer.join(" "));
