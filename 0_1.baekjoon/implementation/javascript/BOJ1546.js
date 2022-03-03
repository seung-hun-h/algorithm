const fs = require('fs');
const input = fs.readFileSync("input.txt").toString().split("\n");

function main() {
    const N = parseInt(input[0]);
    const scores = input[1].split(" ").map(x => parseInt(x));
    const max = getMax(scores);
    console.log(scores.map(x => x / max * 100).reduce((acc, num) => acc + num) / N);
}

function getMax(array) {
    return Math.max.apply(null, array);
}

main();