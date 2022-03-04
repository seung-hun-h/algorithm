const fs = require('fs');
const input = fs.readFileSync("input.txt").toString().trim();

function main() {
    let answer = "";
    for (let i = input; i > 0; i--) {
        answer += `${i}\n`;
    }
    console.log(answer);
}

main();