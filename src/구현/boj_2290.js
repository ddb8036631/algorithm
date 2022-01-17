const fs = require("fs");
let [s, n] = (process.platform === "linux" ? fs.readFileSync("/dev/stdin") : `2 1234567890`).toString().trim().split(" ");
s = +s;
const row = 2 * +s + 3,
    col = n.length * (+s + 2) + n.length - 1,
    mid = Math.floor(row / 2);
const arr = Array.from(Array(row), () => Array(col).fill(" "));
let x = 0;
for (ch of n) {
    switch (ch) {
        case "1":
            draw(["ru", "rd"]);
            break;
        case "2":
            draw(["u", "ru", "m", "ld", "d"]);
            break;
        case "3":
            draw(["u", "ru", "m", "rd", "d"]);
            break;
        case "4":
            draw(["lu", "ru", "m", "rd"]);
            break;
        case "5":
            draw(["u", "lu", "m", "rd", "d"]);
            break;
        case "6":
            draw(["u", "lu", "m", "ld", "rd", "d"]);
            break;
        case "7":
            draw(["u", "ru", "rd"]);
            break;
        case "8":
            draw(["u", "lu", "ru", "m", "ld", "rd", "d"]);
            break;
        case "9":
            draw(["u", "lu", "ru", "m", "rd", "d"]);
            break;
        case "0":
            draw(["u", "lu", "ru", "ld", "rd", "d"]);
    }

    x += s + 3;
}

for (let i = 0; i < row; i++) {
    console.log(arr[i].join(""));
}

function draw(dir) {
    for (d of dir) {
        switch (d) {
            case "u":
                hor(0, x, x + s + 1);
                break;
            case "m":
                hor(mid, x, x + s + 1);
                break;
            case "d":
                hor(row - 1, x, x + s + 1);
                break;
            case "lu":
                ver(x, 0, mid);
                break;
            case "ru":
                ver(x + s + 1, 0, mid);
                break;
            case "ld":
                ver(x, mid, row - 1);
                break;
            case "rd":
                ver(x + s + 1, mid, row - 1);
                break;
        }
    }
}

function hor(target, start, end) {
    for (let i = start + 1; i < end; i++) arr[target][i] = "-";
}

function ver(target, start, end) {
    for (let i = start + 1; i < end; i++) arr[i][target] = "|";
}
