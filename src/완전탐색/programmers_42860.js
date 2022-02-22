function solution(name) {
    let min = name.length - 1;
    let answer = 0;

    for (let i = 0; i < name.length; i++) {
        const ch = name.charAt(i);
        let next = i + 1;

        answer += Math.min(ch.charCodeAt(0) - "A".charCodeAt(0), "Z".charCodeAt(0) - ch.charCodeAt(0) + 1);

        while (next < name.length && name.charAt(next) == "A") next++;
        min = Math.min(min, i * 2 + name.length - next);
        min = Math.min(min, (name.length - next) * 2 + i);
    }
    answer += min;
    return answer;
}

console.log(solution("JEROEN"));
console.log(solution("JAN"));
console.log(solution("BBBBAAAAB"));
