function solution(grid) {
    grid = grid.map((v) => v.split("").map((c) => (c == "S" ? 0 : c == "L" ? 1 : 2)));
    const r = grid.length,
        c = grid[0].length;
    const dx = [-1, 1, 0, 0],
        dy = [0, 0, -1, 1];
    const changeDir = [
        [0, 2, 3],
        [1, 3, 2],
        [2, 1, 0],
        [3, 0, 1],
    ];
    const visit = Array.from(Array(r), () => Array.from(Array(c), () => Array(4).fill(false)));
    const answer = [];

    for (let i = 0; i < r; i++) {
        for (let j = 0; j < c; j++) {
            for (let d = 0; d < 4; d++) {
                if (visit[i][j][d]) continue;

                let x = i,
                    y = j,
                    dir = d;
                let cnt = 0;

                while (!visit[x][y][dir]) {
                    cnt++;
                    visit[x][y][dir] = true;
                    dir = changeDir[dir][grid[x][y]];
                    x += dx[dir];
                    y += dy[dir];
                    x = x >= r ? 0 : x < 0 ? r - 1 : x;
                    y = y >= c ? 0 : y < 0 ? c - 1 : y;
                }

                answer.push(cnt);
            }
        }
    }
    return answer.sort((a, b) => a - b);
}

console.log(solution(["SL", "LR"]));
console.log(solution(["S"]));
console.log(solution(["R", "R"]));
