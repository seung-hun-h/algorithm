const fs = require('fs');
let input = fs.readFileSync('input.txt').toString();

const number = parseInt(input);
let stars = "";
let result = "";
for (let iter=0; iter < number; iter++) {
    stars += "*";
    result += stars + "\n";
}

console.log(result);
