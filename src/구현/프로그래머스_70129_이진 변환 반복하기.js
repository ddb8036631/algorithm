function solution(s) {
    let answer = [];
    let convert = 0,
        removed = 0;

    while (s.length != 1) {
        removed += s.length;
        s = s.replaceAll("0", "");
        removed -= s.length;
        s = s.length.toString(2);
        convert++;
    }

    answer.push(convert, removed);

    return answer;
}

console.log(solution("110010101001"));
console.log(solution("01110"));
console.log(solution("1111111"));
