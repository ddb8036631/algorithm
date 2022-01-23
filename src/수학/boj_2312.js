const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `2
6
24`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const T = +input();
for (let t = 0; t < T; t++) {
    let N = +input();
    const cnt = {};
    while (N > 1) {
        for (let i = 2; i <= N; i++) {
            if (N % i == 0) {
                N = Math.floor(N / i);
                if (!cnt[i]) cnt[i] = 1;
                else cnt[i]++;

                break;
            }
        }
    }

    for (const [k, v] of Object.entries(cnt)) {
        console.log(k, v);
    }
}
