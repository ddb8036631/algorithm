function solution(fees, records) {
    const answer = [];
    const timeline = {};

    for (const record of records) {
        const [time, num] = record.split(" ");
        timeline[num] = timeline[num] ? [...timeline[num], time] : [time];
    }

    const keys = Object.keys(timeline).sort((a, b) => a - b);

    for (const key of keys) {
        let sum = 0;

        for (let i = 0; i < timeline[key].length; i += 2) {
            const s = timeline[key][i],
                e = timeline[key][i + 1] || "23:59";
            const ss = 60 * +s.substring(0, 2) + +s.substring(3),
                es = 60 * +e.substring(0, 2) + +e.substring(3);

            sum += es - ss;
        }

        const fee = fees[1] + (sum > fees[0] ? Math.ceil((sum - fees[0]) / fees[2]) * fees[3] : 0);
        answer.push(fee);
    }

    return answer;
}

console.log(
    solution([180, 5000, 10, 600], ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]),
);
console.log(solution([120, 0, 60, 591], ["16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"]));
console.log(solution([1, 461, 1, 10], ["00:00 1234 IN"]));
