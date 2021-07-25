const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `5
ABC*+DE/-
1
2
3
4
5`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

let N = +input();
let postfix = input().split("");
let values = [];
let stack = [];

for (let i = 0; i < N; i++) values.push(+input());
for (let i = 0; i < postfix.length; i++) {
    let ch = postfix[i];

    if (ch >= "A" && ch <= "Z") {
        stack.push(values[ch.charCodeAt(0) - "A".charCodeAt(0)]);
    } else {
        let b = parseFloat(stack.pop());
        let a = parseFloat(stack.pop());

        stack.push(getResult(a, b, ch));
    }
}

console.log(stack.pop());

function getResult(a, b, ch) {
    let res;

    switch (ch) {
        case "+":
            res = (a + b).toFixed(2);
            break;
        case "-":
            res = (a - b).toFixed(2);
            break;
        case "*":
            res = (a * b).toFixed(2);
            break;
        case "/":
            res = (a / b).toFixed(2);
            break;
    }

    return res;
}
