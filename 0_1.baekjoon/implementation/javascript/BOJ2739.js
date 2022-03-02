const fs = require('fs');
const input = fs.readFileSync("input.txt").toString();

const N = parseInt(input);

let answer = "";
for (let i = 1; i < 10; i++) {
    answer += `${N} * ${i} = ${N * i}\n`;
}
console.log(answer);