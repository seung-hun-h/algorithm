const fs = require('fs');
const input = fs.readFileSync('input.txt').toString().split('\n');

function main() {
    const N = +input[0];
    const numbers = input.slice(1, N + 1).map(x => +x).sort((a, b) => a - b);

    const mean = Math.round(numbers.reduce((acc, num) => acc + num) / N);
    const median = numbers[parseInt(N / 2)];
    const mode = findMode(numbers);
    console.log(Object.is(mean, -0) ? 0 : mean);
    console.log(median);
    console.log(mode);
    console.log(numbers[N - 1] - numbers[0]);
}

function findMode(numbers) {
    const counter = numbers.reduce((acc, num) => 
        acc.set(num, (acc.get(num) || 0) + 1), new Map())

    const max = Math.max(...counter.values());
    const modeKeys = Array.from(counter.keys()).filter((key) => {
        return counter.get(key) === max;
    });
    console.log(counter);
    return modeKeys.length === 1 ? modeKeys[0] : modeKeys[1];
}

main();