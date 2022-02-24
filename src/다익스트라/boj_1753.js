const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");
const [V, E] = input[0].split(" ").map(Number);
const K = +input[1];
const adj = Array.from(Array(V + 1), () => []);
const dist = Array(V + 1).fill(Infinity);
const heapq = [];

for (let i = 2; i < input.length; i++) {
    const [u, v, w] = input[i].split(" ").map(Number);
    adj[u].push([w, v]);
}

dist[K] = 0;
heappush(heapq, [0, K]);

while (heapq.length) {
    const [d, now] = heappop(heapq);

    if (dist[now] < d) continue;

    for (const [w, next] of adj[now]) {
        if (dist[next] > dist[now] + w) {
            dist[next] = dist[now] + w;
            heappush(heapq, [dist[next], next]);
        }
    }
}

console.log(
    dist
        .slice(1)
        .map((v) => (v == Infinity ? "INF" : v))
        .join("\n"),
);

function heappush(q, val) {
    bubbleup(q.push(val) - 1);

    function bubbleup(c) {
        if (c == 0) return;
        let p = Math.floor((c - 1) / 2);
        if (q[p][0] > q[c][0]) {
            [q[p], q[c]] = [q[c], q[p]];
            bubbleup(p);
        }
    }
}

function heappop(q) {
    if (q.length == 0) throw Error("heap is empty.");
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
