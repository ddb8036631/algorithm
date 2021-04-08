const solution = (n, costs) => {
    costs.sort((a, b) => a[2] - b[2]);
    let parent = Array.from({ length: n }, (val, idx) => idx);
    let rank = new Array(n).fill(0);

    const find = (x) => {
        if (parent[x] == x) return x;
        return (parent[x] = find(parent[x]));
    };

    const union = (x, y) => {
        let px = find(x),
            py = find(y);

        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[px] = py;

            if (rank[px] == rank[py]) rank[px]++;
        }
    };

    let cnt = 0;
    let answer = 0;

    for (let idx in costs) {
        let a = find(costs[idx][0]);
        let b = find(costs[idx][1]);

        if (a == b) continue;

        union(a, b);
        answer += costs[idx][2];
        cnt++;

        if (cnt == n - 1) break;
    }

    return answer;
};

solution(4, [
    [0, 1, 1],
    [0, 2, 2],
    [1, 2, 5],
    [1, 3, 1],
    [2, 3, 8],
]);
