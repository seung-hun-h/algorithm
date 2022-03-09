const fs = require('fs');
const input = fs.readFileSync('input.txt').toString().split('\n');

function main() {
    const N = +input[0];

    const result = input.slice(1, N + 1).map(x => x.split(' ').map(y => +y))
                        .sort((a, b) => {
                            if (a[1] !== b[1]) {
                                return a[1] - b[1];
                            }
                            return a[0] - b[0];
                        })
                        .map(x => x.join(' '))
                        .join('\n');

    console.log(result);
}

main();