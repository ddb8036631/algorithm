function solution(n, k) {
    const num = n.toString(k);
    const splited = num.split("0");
    let answer = 0;

    for (let i = 0; i < splited.length; i++) {
        if (splited[i].indexOf(0) >= 0) continue;
        if (!isPrime(splited[i])) continue;
        answer++;
    }

    return answer;
}

function isPrime(num) {
    if (num <= 1) return false;
    for (let i = 2; i <= Math.sqrt(num); i++) {
        if (num % i === 0) return false;
    }
    return true;
}

console.log(solution(437674, 3));
console.log(solution(110011, 10));
