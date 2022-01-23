const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `4
1 2 3 4 5 6 7 8 9 1000
338 304 619 95 343 496 489 116 98 127
931 240 986 894 826 640 965 833 136 138
940 955 364 188 133 254 501 122 768 408`
)
    .toString()
    .trim()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const T = +input();
for (let i = 0; i < T; i++) {
    const arr = input()
        .split(" ")
        .map(Number)
        .sort((a, b) => a - b);
    console.log(arr[arr.length - 3]);
}
