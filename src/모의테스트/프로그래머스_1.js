function solution(left, right) {
    let answer = 0;

    for (let num = left; num <= right; num++) {
        let sqrt = parseInt(Math.sqrt(num));

        if (sqrt * sqrt === num) {
            answer -= num;
        } else answer += num;
    }

    return answer;
}

console.log(solution(13, 17));
console.log(solution(24, 27));
