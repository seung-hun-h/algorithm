const fs = require('fs');
const input = fs.readFileSync('input.txt').toString();

const dp = {0: 1n, 1: 1n, 2: 2n};
function main() {
    const [n, m] = input.split(' ').map(x => +x);
    const result = `${factorial(n) / (factorial(m) * factorial(n - m))}`.replace('n', '');
    console.log(result);
}

function factorial(n) {
    if (dp[n] !== undefined) {
        return dp[n];
    }

    dp[n] = BigInt(n) * factorial(n - 1);
    return dp[n];
}

main();