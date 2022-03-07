const fs = require('fs');
const input = fs.readFileSync('input.txt').toString();
const INF = Infinity;

function main() {
    const N = +input;
    let answer = INF;
    for (let i = 1; i < N; i++) {
        answer = Math.min(answer, findConstructor(i, N));
    }
    console.log(answer === INF ? 0 : answer);
}

function findConstructor(from, to) {
    return isDecomposeSum(from, to) ? from : INF;
}

function isDecomposeSum(from, to) {
    let result = from;

    while (from !== 0) {
        result += from % 10;
        from = parseInt(from/10);
    }

    return result === to;
}

main();