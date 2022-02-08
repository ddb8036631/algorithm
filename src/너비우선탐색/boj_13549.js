const fs = require("fs");
const stdin = (process.platform === "linux" ? fs.readFileSync("/dev/stdin") : `5 17`).toString().trim().split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const [N, K] = input().split(" ").map(Number);
const MAX = 100000;
const time = Array(MAX + 1).fill(-1);
const q = [];

time[N] = 0;
q.push(N);

while (q.length) {
    const now = q.shift();

    if (now == K) {
        console.log(time[now]);
        break;
    }

    if (now * 2 <= MAX && time[now * 2] == -1) {
        time[now * 2] = time[now];
        q.push(now * 2);
    }
    if (now - 1 >= 0 && time[now - 1] == -1) {
        time[now - 1] = time[now] + 1;
        q.push(now - 1);
    }
    if (now + 1 <= MAX && time[now + 1] == -1) {
        time[now + 1] = time[now] + 1;
        q.push(now + 1);
    }
}
