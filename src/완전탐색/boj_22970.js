const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");
const N = +input[0],
    arr = input[1].split(" ").map(Number);
let answer = 1,
    start = 0,
    end = 0;

while (true) {
    if (start >= N - 1) break;

    len = 0;
    end = start + 1;
    while (end < N && arr[end - 1] < arr[end]) end++;

    len += end - start;
    mid = end;
    while (end < N && arr[end - 1] > arr[end]) end++;

    if (mid == end && end == start + 1) {
        start++;
        continue;
    }

    len += end - mid;
    answer = Math.max(answer, len);
    start = end - 1;
}

console.log(answer);
