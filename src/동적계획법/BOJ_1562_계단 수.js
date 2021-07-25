const fs = require("fs");
const stdin = (process.platform === "linux" ? fs.readFileSync("/dev/stdin") : `10`).toString().trim().split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

let N = +input();
let dp = Array.from(Array(10), () => Array.from(Array(N + 1), () => Array(1 << 10).fill(-1)));
const MOD = 1e9;
let answer = 0;

for (let i = 1; i <= 9; i++) {
    init();
    answer += go(i, 1, 1 << i, i+"");
    answer %= MOD;
}

console.log(answer);

function go(now, length, used, s) {
    if (length === N) {
        if(used === (1<<10)-1) {
            console.log(s);
        }
        return used === (1 << 10) - 1 ? 1 : 0;
    }

    if (dp[now][length][used] !== -1) {
        return dp[now][length][used];
    }

    let ret = 0;

    if (now - 1 >= 0) {
        ret += go(now - 1, length + 1, used | (1 << (now - 1)), s+(now-1));
    }

    if (now + 1 <= 9) {
        ret += go(now + 1, length + 1, used | (1 << (now + 1)), s+(now+1));
    }

    ret %= MOD;

    return (dp[now][length][used] = ret);
}

function init() {
    for (let i = 0; i < dp.length; i++) {
        for (let j = 0; j < dp[i].length; j++) {
            for (let k = 0; k < dp[i][j].length; k++) {
                dp[i][j][k] = -1;
            }
        }
    }
}
