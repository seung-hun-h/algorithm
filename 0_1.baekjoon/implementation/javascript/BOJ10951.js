const fs = require('fs');
const input = fs.readFileSync("input.txt").toString().split("\n");

let answer = "";
for (let i = 0; i < input.length; i++) {
    if (input[i].length === 0) break;
    answer += `${input[i].split(" ").map(x => parseInt(x)).reduce((num1, num2) => num1 + num2)}\n`;
}

console.log(answer);
