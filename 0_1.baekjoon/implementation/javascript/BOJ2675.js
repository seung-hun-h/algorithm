const fs = require('fs');
const input = fs.readFileSync("input.txt").toString().split("\n");

const T = parseInt(input[0]);

for (let i = 1; i <= T; i++) {
    console.log(repeatCharacters(input[i]));
}

function repeatCharacters(input) {
    const splited = input.split(" ");
    const count = parseInt(splited[0]);

    let result = "";
    
    for (let char of splited[1].trim()) {
        result += char.repeat(count);
    }

    return result;
}