const fs = require("fs");
const input = (process.platform === "linux" ? fs.readFileSync("/dev/stdin") : `3 1 2`).toString().trim().split(" ").map(Number);
console.log(input.sort((a, b) => a - b).join(" "));
