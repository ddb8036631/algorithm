function solution(n) {
    let cnt = 0;

    while (n != 0) {
        if (n % 2 == 0) {
            n /= 2;
        } else {
            n -= 1;
            cnt++;
        }
    }

    return cnt;
}

console.log(solution(5));
console.log(solution(6));
console.log(solution(5000));
