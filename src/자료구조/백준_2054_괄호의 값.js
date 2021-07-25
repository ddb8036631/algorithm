const fs = require("fs");
const stdin = (process.platform === "linux" ? fs.readFileSync("/dev/stdin") : `({})`).toString().trim().split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const s = input().split("");
let err = false;
let sum = 0,
    tmp = 1;
let stack = [];

for (let i = 0; i < s.length; i++) {
    let ch = s[i];

    if (ch === "[") {
        stack.push(ch);
        tmp *= 3;
    } else if (ch === "(") {
        stack.push(ch);
        tmp *= 2;
    } else if (ch === "]") {
        if (stack.length === 0) {
            err = true;
            sum = 0;
            break;
        }

        if (stack[stack.length - 1] === "[") {
            if (s[i - 1] === "[") sum += tmp;
            stack.pop();
            tmp /= 3;
        } else {
            err = true;
            break;
        }
    } else if (ch === ")") {
        if (stack.length === 0) {
            err = true;
            sum = 0;
            break;
        }

        if (stack[stack.length - 1] === "(") {
            if (s[i - 1] === "(") sum += tmp;
            stack.pop();
            tmp /= 2;
        } else {
            err = true;
            break;
        }
    }
}

if (err || stack.length) console.log(0);
else console.log(sum);
