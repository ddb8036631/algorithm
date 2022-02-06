const fs = require("fs");
const stdin = (process.platform === "linux" ? fs.readFileSync("/dev/stdin") : `2 1 5 3 4`).toString().trim().split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const arr = input().split(" ").map(Number);
while (true) {
    for (let i = 0; i < 4; i++) {
        if (arr[i] > arr[i + 1]) {
            const tmp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = tmp;
            console.log(arr.join(" "));
        }
    }
    if (arr.toString() === [1, 2, 3, 4, 5].toString()) break;
}
