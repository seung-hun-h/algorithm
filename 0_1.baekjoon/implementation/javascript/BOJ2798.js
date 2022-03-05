const fs = require('fs');
const input = fs.readFileSync('input.txt').toString().split('\n');

function main() {
    const [N, M] = input[0].split(" ").map(x => parseInt(x));
    const array = input[1].split(" ").map(x => parseInt(x)).sort((a, b) => a - b);
    let answer = 0;
    for (let i = 0; i < N; i++) {
        for (let j = i + 1; j < N; j++) {
            for (let k = j + 1; k < N; k++) {
                const current = array[i] + array[j] + array[k];
                if (current > M) break;
                answer = Math.max(answer, current);
            }
        }
    }
    console.log(answer);
}

main();