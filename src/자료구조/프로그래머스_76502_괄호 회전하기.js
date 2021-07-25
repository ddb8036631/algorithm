function solution(s) {
    let answer = 0;

    for (let i = 0; i < s.length; i++) {
        let tmp = s.substring(i) + s.substring(0, i);
        let stack = [];
        let wrong = false;

        for (let j = 0; j < tmp.length; j++) {
            let ch = tmp[j];

            if (ch === "(" || ch === "{" || ch === "[") {
                stack.push(ch);
            } else if (ch === ")") {
                if (stack.length === 0) {
                    wrong = true;
                    break;
                }

                if (stack.length && stack[stack.length - 1] === "(") stack.pop();
            } else if (ch === "}") {
                if (stack.length === 0) {
                    wrong = true;
                    break;
                }

                if (stack.length && stack[stack.length - 1] === "{") stack.pop();
            } else if (ch === "]") {
                if (stack.length === 0) {
                    wrong = true;
                    break;
                }

                if (stack.length && stack[stack.length - 1] === "[") stack.pop();
            }
        }

        if (!wrong && !stack.length) answer++;
    }

    return answer;
}

console.log(solution("[](){}"));
console.log(solution("}]()[{"));
console.log(solution("[)(]"));
console.log(solution("}}}"));
