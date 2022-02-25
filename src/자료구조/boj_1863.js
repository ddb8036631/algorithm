const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");
const n = +input[0];
const stack = [];
let answer = 0;

for (let i = 1; i <= n; i++) {
    const [x, y] = input[i].split(" ").map(Number);

    while (stack.length && y < stack[stack.length - 1]) {
        answer++;
        stack.pop();
    }

    if (!y || (stack.length && y == stack[stack.length - 1])) continue;
    stack.push(y);
}

console.log(answer + stack.length);
