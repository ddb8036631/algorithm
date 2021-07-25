function solution(absolutes, signs) {
    return absolutes.reduce((prev, curr, curIdx) => {
        return prev + (signs[curIdx] ? curr : -curr);
    }, 0);
}

console.log(solution([4, 7, 12], [true, false, true]));
console.log(solution([1, 2, 3], [false, false, true]));
