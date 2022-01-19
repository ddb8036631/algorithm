const fs = require("fs");
const [A, B] = (process.platform === "linux" ? fs.readFileSync("/dev/stdin") : `1 40`).toString().trim().split(" ").map(Number);
let aq = Math.floor(A / 4);
let bq = Math.floor(B / 4);
let ar = A % 4;
let br = B % 4;

if (ar === 0) {
    aq--;
    ar = 4;
}
if (br === 0) {
    bq--;
    br = 4;
}

console.log(Math.abs(aq - bq) + Math.abs(ar - br));
