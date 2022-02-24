const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");
const [N, M, X] = input[0].split(" ").map(Number);
const adj = Array.from(Array(N + 1), () => []);
const dist = Array.from(Array(N + 1), () => Array(N + 1).fill(Infinity));
let answer = 0;

for (let i = 1; i < input.length; i++) {
    const [u, v, w] = input[i].split(" ").map(Number);
    adj[u].push([w, v]);
}

for (let s = 1; s <= N; s++) {
    const heapq = [];
    dist[s][s] = 0;
    heappush(heapq, [0, s]);

    while (heapq.length) {
        const [d, now] = heappop(heapq);

        if (dist[s][now] < d) continue;

        for (const [w, next] of adj[now]) {
            if (dist[s][next] > dist[s][now] + w) {
                dist[s][next] = dist[s][now] + w;
                heappush(heapq, [dist[s][next], next]);
            }
        }
    }
}

for (let s = 1; s <= N; s++) answer = Math.max(answer, dist[s][X] + dist[X][s]);

console.log(answer);

function heappush(q, val) {
    bubbleup(q.push(val) - 1);

    function bubbleup(c) {
        if (c == 0) return;
        const p = Math.floor((c - 1) / 2);
        if (q[p][0] > q[c][0]) {
            [q[p], q[c]] = [q[c], q[p]];
            bubbleup(p);
        }
    }
}

function heappop(q) {
    if (q.length == 0) throw Error("heapq is empty.");
    if (q.length == 1) return q.pop();

    const top = q[0];
    q[0] = q.pop();
    trickledown(0);
    return top;

    function trickledown(p) {
        if (p * 2 + 1 >= q.length) return;
        const lc = p * 2 + 1,
            rc = p * 2 + 2,
            minc = rc >= q.length || q[lc][0] < q[rc][0] ? lc : rc;
        if (q[minc][0] < q[p][0]) {
            [q[minc], q[p]] = [q[p], q[minc]];
            trickledown(minc);
        }
    }
}
