const fs = require('fs');
const input = fs.readFileSync('input.txt').toString().split('\n');

function main() {
    const N = +input[0];

    const sorted = Array.from(new Set(input.slice(1, N + 1))).sort((prev, curr) => {
        if (prev.length != curr.length) {
            return prev.length - curr.length;
        } else {
            return prev.localeCompare(curr);
        }
    });

    console.log(sorted.join("\n"));
}

main();