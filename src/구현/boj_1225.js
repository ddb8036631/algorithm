const fs = require("fs");
const [A, B] = (process.platform === "linux" ? fs.readFileSync("/dev/stdin") : `123 45`).toString().trim().split(" ");
const aa = A.split("").map(Number);
const bb = B.split("").map(Number);

console.log(aa.reduce((prev, cur) => prev + cur) * bb.reduce((prev, cur) => prev + cur));
