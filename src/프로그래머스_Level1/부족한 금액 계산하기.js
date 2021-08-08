function solution(price, money, count) {
    let cost = Array.from({ length: count }, (v, i) => i + 1).reduce((prev, cur) => (prev += price * cur), 0);

    return cost > money ? cost - money : 0;
}

console.log(solution(3, 20, 4));
