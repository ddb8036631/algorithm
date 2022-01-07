const fs = require("fs");
const stdin = fs.readFileSync("/dev/stdin").toString().split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

while ((ss = input())) {
    const [s, t] = ss.split(" ");
    let i = 0,
        j = 0;

    while (i < s.length && j < t.length) {
        if (s[i] === t[j]) {
            i++;
            j++;
        } else {
            j++;
        }
    }
    console.log(i === s.length ? "Yes" : "No");
}
