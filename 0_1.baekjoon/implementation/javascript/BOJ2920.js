const fs = require('fs');
const input = fs.readFileSync("input.txt").toString();

const numbers = input.split(" ").map(x => parseInt(x));

if (isAscending(numbers)) {
    console.log("ascending");
} else if (isDescending(numbers)) {
    console.log("descending");
} else {
    console.log("mixed");
}

function isAscending(array) {
    let prev = 0;
    for (let curr of array) {
        if (curr <= prev) {
            return false;
        }
        prev = curr;
    }

    return true;
}

function isDescending(array) {
    let prev = 9;
    for (let curr of array) {
        if (curr >= prev) {
            return false;
        }
        prev = curr;
    }

    return true;
}
