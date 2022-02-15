const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `english is a west germanic
language originating in england
and is the first language for
most people in the united
kingdom the united states
canada australia new zealand
ireland and the anglophone
caribbean it is used
extensively as a second
language and as an official
language throughout the world
especially in common wealth
countries and in many
international organizations
`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const cnt = Array(26).fill(0);
const answer = [];
let max = 0;

while (true) {
    const line = input()?.replace(/\s/g, "");
    if (!line) break;

    for (const c of line) {
        const i = c.charCodeAt(0) - "a".charCodeAt(0);
        cnt[i]++;
        max = Math.max(max, cnt[i]);
    }
}

for (let i = 0; i < 26; i++) if (cnt[i] == max) answer.push(String.fromCharCode(i + "a".charCodeAt(0)));
console.log(answer.join(""));
