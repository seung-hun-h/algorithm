const fs = require('fs');
const input = fs.readFileSync('input.txt').toString();

function main() {
    const N = +input;
    let result = 1;
    let count = 0;
    while (result < N) {
        result += (6 * count++);
    }
    console.log(count === 0 ? 1 : count);
}
main();
/**
 * 1
 * 7
 * 19
 * 37
 * 61
 */