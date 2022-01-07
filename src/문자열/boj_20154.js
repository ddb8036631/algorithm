const fs = require("fs");
const stdin = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const s = input();
const dic = { A: 3, B: 2, C: 1, D: 2, E: 3, F: 3, G: 3, H: 3, I: 1, J: 1, K: 3, L: 1, M: 3, N: 3, O: 1, P: 2, Q: 2, R: 2, S: 1, T: 2, U: 1, V: 1, W: 2, X: 2, Y: 2, Z: 1 };
let arr = [];
for (ch of s) arr.push(dic[ch]);

while (arr.length > 1) {
    const tmp = [];
    for (let i = 0; i < arr.length; i += 2) tmp.push(i + 1 < arr.length ? (arr[i] + arr[i + 1]) % 10 : arr[i]);
    arr = tmp;
}

console.log(arr[0] % 2 == 1 ? "I'm a winner!" : "You're the winner?");
