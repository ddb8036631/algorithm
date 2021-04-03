function solution(s) {
    return s
        .split(" ")
        .map((word) => (word == "" ? "" : word[0].toUpperCase() + word.slice(1).toLowerCase()))
        .join(" ");
}

console.log(solution("3people unFollowed me"));
console.log(solution("for the last week"));
console.log(solution("A B C D E"));
console.log(solution("         "));
