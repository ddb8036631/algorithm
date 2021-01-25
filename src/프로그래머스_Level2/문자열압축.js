function ReplaceAt(input, replace, start, end) {
    let tmp = [];
    for (let idx = 0; idx < replace.length; idx++) tmp.push(replace[idx]);

    let arr1 = input.slice(0, start);
    let arr2 = input.slice(end + 1);

    input.splice(start, end - start + 1);

    return arr1.concat(tmp, arr2);
}

function solution(s) {
    let answer = s.length;

    for (let delta = 1; delta < s.length; delta++) {
        let sb = [];

        let start = 0,
            end = 0 + delta;

        while (start != end && end <= s.length) {
            let splited = s.substring(start, end);

            if (sb.length == 0) {
                for (let idx = 0; idx < splited.length; idx++) {
                    sb.push(splited[idx]);
                }
            } else {
                let prev = sb.slice(sb.length - delta, sb.length).join("");

                if (prev.length != 0 && prev === splited) {
                    let countIndexEnd = sb.length - delta - 1;

                    if (countIndexEnd >= 0) {
                        if (!isNaN(sb[countIndexEnd])) {
                            let countIndexStart = countIndexEnd - 1;

                            while (countIndexStart >= 0 && !isNaN(sb[countIndexStart])) countIndexStart--;
                            countIndexStart++;

                            let count = parseInt(sb.slice(countIndexStart, countIndexEnd + 1).join(""));
                            sb = ReplaceAt(sb, count + 1 + "", countIndexStart, countIndexEnd);
                        } else {
                            sb.splice(countIndexEnd + 1, 0, "2");
                        }
                    } else {
                        sb.splice(0, 0, "2");
                    }
                } else {
                    for (let idx = 0; idx < splited.length; idx++) {
                        sb.push(splited[idx]);
                    }
                }
            }

            start = end;
            end = start + delta > s.length ? s.length : start + delta;
        }

        // console.log("delta : " + delta + ", sb : " + sb.join("") + ", sb.length : " + sb.length);
        answer = Math.min(answer, sb.length);
    }

    return answer;
}

// solution("aabbaccc");
// solution("ababcdcdababcdcd");
// solution("abcabcdede");
// solution("abcabcabcabcdededededede");
// solution("xababcdcdababcdcd");
solution("xxxxxxxxxxyyy");
