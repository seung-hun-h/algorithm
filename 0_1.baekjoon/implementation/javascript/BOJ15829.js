const fs = require('fs');
const input = fs.readFileSync('input.txt').toString().split('\n');

function main() {
    const L = +input[0];
    const sequence = input[1];
    const r = [1];
    const mod = 1234567891;
    for (let i = 1; i < L; i++) {
        r.push(r[i - 1] * 31 % mod);
    }
    let answer = 0;
    for (let idx in sequence) {
        answer += (sequence.charCodeAt(idx) - 'a'.charCodeAt(0) + 1) * r[idx];
        answer %= mod;
    }

    console.log(answer);
}

main();
