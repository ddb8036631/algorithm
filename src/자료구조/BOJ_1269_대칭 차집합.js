const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? "/dev/stdin"
        : `3 5
1 2 4
2 3 4 5 6`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

let [a, b] = input().split(" ").map(Number);
let arr_a = input().split(" ").map(Number);
let arr_b = input().split(" ").map(Number);
let set = new Set();

for (let i = 0; i < a; i++) {
    if (!set.has(arr_a[i])) set.add(arr_a[i]);
    else set.delete(arr_a[i]);
}

for (let i = 0; i < b; i++) {
    if (!set.has(arr_b[i])) set.add(arr_b[i]);
    else set.delete(arr_b[i]);
}

console.log(set.size);
