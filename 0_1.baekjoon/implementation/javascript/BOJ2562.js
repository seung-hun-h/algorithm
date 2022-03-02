const fs = require('fs');
const input = fs.readFileSync("input.txt").toString().split("\n");

let idx = 0;
let max = 0;

for (let i = 0; i < 9; i++) {
    const number = parseInt(input[i]);

    if (max < number) {
        max = number;
        idx = i;
    }
}
console.log(input);
console.log(`${max}\n${idx+1}`);