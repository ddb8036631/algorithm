const solution = (n, costs) => {
    let visit = Array(n).fill(false);
    let pi = Array(n).fill(0);
    let key = Array(n).fill(Number.MAX_VALUE);
    let adj = Array.from(Array(n), () => Array(n).fill(0));

    for (let idx in costs) {
        let u = costs[idx][0];
        let v = costs[idx][1];
        let cost = costs[idx][2];

        adj[u][v] = adj[v][u] = cost;
    }

    pi[0] = -1;
    key[0] = 0;

    for (let i = 0; i < n; i++) {
        let min = Number.MAX_VALUE;
        let now = -1;

        for (let j = 0; j < n; j++) {
            if (!visit[j] && key[j] < min) {
                min = key[j];
                now = j;
            }
        }

        visit[now] = true;

        for (let next = 0; next < n; next++) {
            if (!visit[next] && adj[now][next] != 0 && adj[now][next] < key[next]) {
                pi[next] = now;
                key[next] = adj[now][next];
            }
        }
    }

    let answer = 0;
    for (let k of key) answer += k;

    return answer;
};

solution(4, [
    [0, 1, 1],
    [0, 2, 2],
    [1, 2, 5],
    [1, 3, 1],
    [2, 3, 8],
]);
