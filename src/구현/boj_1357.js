const fs = require("fs");
const [X, Y] = (process.platform === "linux" ? fs.readFileSync("/dev/stdin") : `456 789`).toString().trim().split(" ");
const xx = X.split("").reverse().join("");
const yy = Y.split("").reverse().join("");
console.log(Number((Number(xx) + Number(yy) + "").split("").reverse().join("")));
