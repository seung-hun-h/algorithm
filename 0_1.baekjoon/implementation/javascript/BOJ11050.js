const fs = require('fs');
const input = fs.readFileSync('input.txt').toString();

const dp = {0: 1, 1: 1, 2: 2};
function main() {
    const [n, m] = input.split(' ').map(x => +x);
    const result = `${factorial(n) / (factorial(m) * factorial(n - m))}`;
    console.log(result);
}

function factorial(n) {
    if (dp[n] !== undefined) {
        return dp[n];
    }

    dp[n] = n * factorial(n - 1);
    return dp[n];
}

main();