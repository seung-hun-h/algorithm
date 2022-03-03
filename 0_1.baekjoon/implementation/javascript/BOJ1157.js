const fs = require('fs');
const input = fs.readFileSync("input.txt").toString().trim().toUpperCase()

const counter = countCharacter(input);
console.log(findMode(counter));

function countCharacter(string) {
    const result = {};

    for (let char of string) {
        result[char] = result[char] || 0;
        result[char]++;
    }

    return result;
}

function findMode(counter) {
    let max = 0;
    let char = "?";
    let isDuplicated = false;

    for (let key in counter) {
        if (counter[key] == max) {
            isDuplicated = true;
            continue;
        }

        if (max < counter[key]) {
            max = counter[key];
            char = key;
            isDuplicated = false;
        }
    }
    
    return isDuplicated ? "?" : char;
}



// 1. 글자 카운트
// 2. 정렬
// 3. 찾기 -> 중복이면 ?
