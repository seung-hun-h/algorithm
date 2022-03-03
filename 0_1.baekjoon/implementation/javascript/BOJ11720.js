const fs = require('fs');
const input = fs.readFileSync("input.txt").toString().split("\n");

console.log(input[1].split("").map(x => parseInt(x)).reduce((prev, curr) => prev + curr));