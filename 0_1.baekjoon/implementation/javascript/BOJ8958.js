const fs = require('fs');
const input = fs.readFileSync("input.txt").toString().split("\n");

const T = parseInt(input[0]);

let answer = "";

for (let i = 1; i <= T; i++) {
    answer += `${calcScore(input[i].trim())}\n`;
}

console.log(answer);

function calcScore(results) {
    let score = 0;
    let current = 0;

    for (let result of results) {
        if (result === 'O') {
            current++;
        } else {
            current = 0;
        }
        score += current;
    }

    return score;
}