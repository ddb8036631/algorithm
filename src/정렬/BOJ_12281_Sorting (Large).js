const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `2
5
5 2 4 3 1
7
-5 -12 87 2 88 20 11`
)
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const T = +input();
let answer = "";

for (let tc = 1; tc <= T; tc++) {
    const N = +input();
    const arr = input().split(" ").map(Number);
    const isOdd = Array(N);
    let minHeap = [],
        maxHeap = [];

    arr.forEach((v, i) => {
        if (v % 2) isOdd[i] = true;
        else isOdd[i] = false;
    });

    for (let num of arr) {
        if (num % 2) minHeap.push(num);
        else maxHeap.push(num);
    }

    minHeap.sort((a, b) => a - b);
    maxHeap.sort((a, b) => b - a);

    for (let idx = 0; idx < N; idx++) {
        if (isOdd[idx]) arr[idx] = minHeap.shift();
        else arr[idx] = maxHeap.shift();
    }

    answer = answer.concat("Case #" + tc + ": " + arr.join(" ") + "\n");
}

console.log(answer);
