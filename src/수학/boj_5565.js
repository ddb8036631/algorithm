const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");
console.log(
    +input[0] -
        input
            .slice(1)
            .map(Number)
            .reduce((acc, cur) => acc + cur),
);
