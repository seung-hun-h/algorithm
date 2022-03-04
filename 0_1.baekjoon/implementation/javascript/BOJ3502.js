const fs = require('fs');
const input = fs.readFileSync("input.txt").toString().trim().split("\n");

function main() {
    console.log(new Set(input.map(x => x % 42)).size);
}

main();