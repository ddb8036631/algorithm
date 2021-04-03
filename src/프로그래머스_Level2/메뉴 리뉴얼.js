function solution(orders, course) {
    const candidateMap = new Map();
    const maxCountMap = new Map();
    const courseSet = new Set(course);

    function comb(idx, order, result) {
        if (courseSet.has(result.length)) {
            let count = candidateMap.get(result) || 0;
            candidateMap.set(result, ++count);

            const max = maxCountMap.get(result.length) || 0;

            if (max < count) {
                maxCountMap.set(result.length, count);
            }
        }

        for (let i = idx; i < order.length; i++) {
            comb(i + 1, order, result + order[i]);
        }
    }

    orders.map((order) => order.split("").sort().join("")).forEach((order) => comb(0, order, ""));

    console.log(
        course
            .map((length) => {
                const max = maxCountMap.get(length);
                return Array.from(candidateMap)
                    .filter((e) => e[0].length === length && e[1] >= 2 && e[1] === max)
                    .map((e) => e[0]);
            })
            .flatMap((e) => e)
            .sort(),
    );

    return course
        .map((length) => {
            const max = maxCountMap.get(length);
            return Array.from(candidateMap)
                .filter((e) => e[0].length === length && e[1] >= 2 && e[1] === max)
                .map((e) => e[0]);
        })
        .flatMap((e) => e)
        .sort();
}

console.log(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"], [2, 3, 4]));
// console.log(solution(["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"], [2, 3, 5]));
// console.log(solution(["XYZ", "XWY", "WXA"], [2, 3, 4]));
