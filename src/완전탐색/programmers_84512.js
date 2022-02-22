let cnt = 0;
let answer = 0;
const vowel = ["A", "E", "I", "O", "U"];

function solution(word) {
    answer = 0;
    cnt = 0;

    dfs("", word);

    return answer;
}

function dfs(s, word) {
    if (s == word) answer = cnt;

    cnt++;
    if (s.length == 5) return;

    for (let i = 0; i < vowel.length; i++) dfs(s + vowel[i], word);
}

console.log(solution("AAAAE"));
console.log(solution("AAAE"));
console.log(solution("I"));
console.log(solution("EIO"));
