const fs = require('fs');
const input = fs.readFileSync("input.txt").toString().trim().split(" ");

function main() {
    console.log(input.map(x => x * x).reduce((acc, num) => acc + num) % 10);
}

main();