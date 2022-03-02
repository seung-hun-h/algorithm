const fs = require('fs');
const input = fs.readFileSync("input.txt").toString().split("\n");

const T = parseInt(input[0]);

let answer = "";

for (let i = 1; i <= T; i++) {
    answer += `${sum(input[i].split(" ").map(x => parseInt(x)))}\n`;
}

console.log(answer);

function sum([num1, num2]) {
    return num1 + num2;
}