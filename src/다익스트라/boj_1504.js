const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");
const [N, E] = input[0].split(" ").map(Number);
const adj = Array.from(Array(N + 1), () => []);
const dist = Array(N + 1).fill(Infinity);
let v1, v2;
let stov1, stov2, v1tov2, v1toe, v2toe;
let answer = Infinity;

for (let i = 1; i <= E; i++) {
    const [a, b, c] = input[i].split(" ").map(Number);
    adj[a].push([b, c]);
    adj[b].push([a, c]);
}

[v1, v2] = input[input.length - 1].split(" ").map(Number);

dijkstra(1);
[stov1, stov2] = [dist[v1], dist[v2]];

dijkstra(v1);
[v1tov2, v1toe] = [dist[v2], dist[N]];

dijkstra(v2);
v2toe = dist[N];

answer = Math.min(answer, stov1 + v1tov2 + v2toe);
answer = Math.min(answer, stov2 + v1tov2 + v1toe);

console.log(answer == Infinity ? -1 : answer);

function dijkstra(start) {
    const heapq = [];
    dist.fill(Infinity);
    dist[start] = 0;
    heappush(heapq, [0, start]);

    while (heapq.length) {
        const [d, now] = heappop(heapq);

        if (dist[now] < d) continue;

        for (const [next, c] of adj[now]) {
            if (dist[next] > dist[now] + c) {
                dist[next] = dist[now] + c;
                heappush(heapq, [dist[next], next]);
            }
        }
    }
}

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
    if (q.length == 0) throw new Error("heapq is empty.");
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
