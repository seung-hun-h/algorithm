const fs = require('fs');
const input = fs.readFileSync('input.txt').toString().split('\n');

function main() {
    let idx = 0;
    let answer = "";
    while (true) {
        const [side1, side2, side3] = input[idx++].split(" ").map(x => parseInt(x)).sort((a, b) => a - b);
        if ([side1, side2, side3].reduce((acc, num) => acc + num) === 0) break;

        if ((side3 ** 2) === (side1 ** 2 + side2 ** 2)) {
            answer += 'right\n';
        } else {
            answer += 'wrong\n';
        }
    }

    console.log(answer);
}

main();