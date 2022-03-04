const fs = require('fs');
const input = fs.readFileSync("input.txt").toString().trim().split("\n");

function main() {
    const [N, X] = input[0].split(" ").map(x => +x);
    console.log(input[1].split(" ").filter(x => x < X).join(" "));
}

main();