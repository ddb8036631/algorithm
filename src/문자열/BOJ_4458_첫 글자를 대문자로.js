const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim()
    : `5
powdered Toast Man
skeletor
Electra Woman and Dyna Girl
she-Ra Princess of Power
darth Vader`
).split("\n");
const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

console.log(
    stdin
        .filter((e, i) => i > 0)
        .map((e) => e[0].toUpperCase() + e.substring(1))
        .join("\n"),
);
