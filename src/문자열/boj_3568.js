const fs = require("fs");
const input = (process.platform === "linux" ? fs.readFileSync("/dev/stdin") : `int& aAbB*[]&, asdfasdf, qwe*;`).toString().trim().replace(";", "");
const splited = input.split(", ");
let base;
[base, splited[0]] = splited[0].split(" ");

console.log(
    splited
        .map((val) => {
            const variable = val.match(/\w/g);
            val = val.replace(/\w/g, "");
            return base + val.split("").reverse().join("").replace(/\]\[/g, "[]") + " " + variable.join("") + ";";
        })
        .reduce((prev, now) => prev + "\n" + now),
);
