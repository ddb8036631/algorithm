const fs = require("fs");
const stdin = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : `8
LSFTL 4 2 4
MULTC 3 7 12
NOT 2 0 4
SUB 4 4 3
ASFTR 6 4 1
MULT 7 7 5
RLC 6 4 14
RR 1 5 4`
)
    .toString()
    .split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();
const N = Number(input());
const map = {
    ADD: "0000",
    SUB: "0001",
    MOV: "0010",
    AND: "0011",
    OR: "0100",
    NOT: "0101",
    MULT: "0110",
    LSFTL: "0111",
    LSFTR: "1000",
    ASFTR: "1001",
    RL: "1010",
    RR: "1011",
};
const answer = [];
for (let i = 0; i < N; i++) {
    const command = input().split(" ");
    const cFlag = command[0][command[0].length - 1] === "C" ? true : false;
    const opcode = map[cFlag ? command[0].substring(0, command[0].length - 1) : command[0]] + (cFlag ? "1" : "0");
    const rD = ("00" + Number(command[1]).toString(2)).slice(-3);
    const rA = ("00" + Number(command[2]).toString(2)).slice(-3);
    const rest = cFlag ? ("000" + Number(command[3]).toString(2)).slice(-4) : ("00" + Number(command[3]).toString(2)).slice(-3) + "0";
    answer.push(opcode + 0 + rD + rA + rest);
}

console.log(answer.reduce((prev, cur) => prev + "\n" + cur));
