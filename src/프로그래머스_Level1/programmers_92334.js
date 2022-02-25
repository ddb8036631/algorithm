function solution(id_list, report, k) {
    const to = {};
    const from = {};

    for (const s of report) {
        const [a, b] = s.split(" ");
        if (!to[a]) to[a] = [];
        if (to[a].indexOf(b) == -1) to[a].push(b);
        if (!from[b]) from[b] = [];
        if (from[b].indexOf(a) == -1) from[b].push(a);
    }

    return id_list.map((v1) => {
        let cnt = 0;
        v1 in to &&
            to[v1].forEach((v2) => {
                if (from[v2].length >= k) cnt++;
            });

        return cnt;
    });
}

console.log(solution(["muzi", "frodo", "apeach", "neo"], ["muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"], 2));
console.log(solution(["con", "ryan"], ["ryan con", "ryan con", "ryan con", "ryan con"], 3));
