const fs = require('fs');
const input = fs.readFileSync("input.txt").toString().trim();

function main() {
    console.log(Math.max.apply(null, (input.split(" ").map(x => +x.split("").reverse().join("")))));
}

main();