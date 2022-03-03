const fs = require('fs');
const input = fs.readFileSync("input.txt").toString().split("\n");

let answer = "";
for (let i = 0; i < input.length; i++) {
    if (input[i].length === 0) break;
    const result = input[i].split(" ").map(x => parseInt(x)).reduce((num1, num2) => num1 + num2);

    if (result !== 0) {
        answer += `${result}\n`;
    }
}

console.log(answer);
