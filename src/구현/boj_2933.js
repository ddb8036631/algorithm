const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `10 10
xxxxxxxxxx
....x.....
...xxx....
.....x....
....xx....
.....x....
xxxxxx....
..x.......
.xxxx.....
...xxxxxxx
10
9 8 7 6 5 4 3 2 1 1`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const [R, C] = input().split(" ").map(Number);
const map = [];
const visit = Array.from(Array(R), () => Array(C).fill(false));
for (let i = 0; i < R; i++) map.push(input().split(""));
input();
const commands = input().split(" ").map(Number);
const dx = [-1, 1, 0, 0];
const dy = [0, 0, -1, 1];

for (let i = 0; i < commands.length; i++) {
    const target = {};

    if (i % 2 === 0) {
        for (let j = 0; j < C; j++) {
            if (map[R - commands[i]][j] === ".") continue;
            map[R - commands[i]][j] = ".";
            target.x = R - commands[i];
            target.y = j;
            break;
        }
    } else {
        for (let j = C - 1; j >= 0; j--) {
            if (map[R - commands[i]][j] === ".") continue;
            map[R - commands[i]][j] = ".";
            target.x = R - commands[i];
            target.y = j;
            break;
        }
    }

    if (!Object.keys(target).length) continue;
    findCluster(target);
}

for (let i = 0; i < R; i++) console.log(map[i].join(""));

function findCluster(target) {
    const tx = target.x,
        ty = target.y;

    for (let d1 = 0; d1 < 4; d1++) {
        const side_x = tx + dx[d1];
        const side_y = ty + dy[d1];

        if (side_x < 0 || side_x >= R || side_y < 0 || side_y >= C || map[side_x][side_y] === ".") continue;

        const queue = [];
        let cluster = [];
        for (let i = 0; i < R; i++) visit[i].fill(false);
        visit[side_x][side_y] = true;
        queue.push([side_x, side_y]);
        cluster.push([side_x, side_y]);

        while (queue.length) {
            const [x, y] = queue.shift();
            if (x === R - 1) {
                cluster = [];
                break;
            }

            for (let d2 = 0; d2 < 4; d2++) {
                const nx = x + dx[d2];
                const ny = y + dy[d2];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C || visit[nx][ny] || map[nx][ny] === ".") continue;

                visit[nx][ny] = true;
                queue.push([nx, ny]);
                cluster.push([nx, ny]);
            }
        }

        if (!cluster.length) continue;
        down(cluster);
    }
}

function down(cluster) {
    while (true) {
        let isBottom = false;
        for (const [x, y] of cluster) {
            if (x === R - 1 || (x + 1 < R && map[x + 1][y] === "x" && cluster.findIndex((pos) => pos[0] === x + 1 && pos[1] === y) === -1)) {
                isBottom = true;
            }
        }

        if (isBottom) break;

        for (const [x, y] of cluster) map[x][y] = ".";
        for (const arr of cluster) {
            map[arr[0] + 1][arr[1]] = "x";
            arr[0] += 1;
        }
    }
}
