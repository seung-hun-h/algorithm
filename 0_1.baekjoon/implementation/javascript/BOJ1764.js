const fs = require('fs');
const input = fs.readFileSync('input.txt').toString().split('\n');

function main() {
    const [N, M] = input[0].split(' ').map(x => +x);

    const nameSet = new Set();
    for (let i = 1; i < N + 1; i++) {
        nameSet.add(input[i].trim());
    }

    const answer = input.slice(N + 1, N + M + 1)
                        .filter((value) => nameSet.has(value.trim()))
                        .map(x => x.trim())
                        .sort();
    console.log(answer.length);
    console.log(answer.join('\n'));
}

main();