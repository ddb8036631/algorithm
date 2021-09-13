function solution(lottos, win_nums) {
    let rank = [6, 6, 5, 4, 3, 2, 1];
    let zero = lottos.filter((val) => val === 0).length;
    let cnt = 0;

    for (let num of win_nums) {
        if (lottos.indexOf(num) !== -1) {
            cnt++;
        }
    }

    return [rank[cnt + zero], rank[cnt]];
}

console.log(solution([44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19]));
console.log(solution([0, 0, 0, 0, 0, 0], [38, 19, 20, 40, 15, 25]));
console.log(solution([45, 4, 35, 20, 3, 9], [20, 9, 3, 45, 4, 35]));
