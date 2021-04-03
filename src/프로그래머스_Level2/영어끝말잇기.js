function solution(n, words) {
    let answer = [];
    let idx = 1;
    let found = false;
    let set = new Set();

    set.add(words[0]);

    while (true) {
        if (idx >= words.length) break;

        if (words[idx - 1].charAt(words[idx - 1].length - 1) != words[idx].charAt(0) || set.has(words[idx])) {
            found = true;
            break;
        }

        set.add(words[idx]);
        idx++;
    }

    if (found) answer.push((idx % n) + 1, parseInt(idx / n) + 1);
    else answer.push(0, 0);

    return answer;
}

solution(3, ["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]);
// solution(5, ["hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"]);
// solution(2, ["hello", "one", "even", "never", "now", "world", "draw"]);
