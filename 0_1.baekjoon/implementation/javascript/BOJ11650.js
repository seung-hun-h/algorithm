const fs = require('fs');
const input = fs.readFileSync('input.txt').toString().split('\n');

function main() {
    const N = parseInt(input[0]);
    let answer = '';
    input.slice(1, N + 1)
        .map(x => x.split(' ').map(y => +y))
        .sort((a, b) => {
            if (a[0] !== b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1]
            }
        })
        .forEach(x => {
            answer += `${x.join(' ')}\n`;
        });

    console.log(answer);
}

main();