const fs = require('fs');
const input = fs.readFileSync('input.txt').toString().split('\n');

function main() {
    const T = +input[0];
    let answer = "";
    for (let t = 0; t < T; t++) {
        const idx = 2 * t + 1;
        answer += `${countResidents(+input[idx], +input[idx + 1])}\n`;
    }

    console.log(answer);
}

function countResidents(floor, room) {
    const dp = [];
    for (let i = 0; i <= room; i++) {
        dp.push(i);
    }

    for (let i = 1; i <= floor; i++) {
        for (let j = 1; j <= room; j++) {
            dp[j] += dp[j - 1];
        }
    }

    return dp[room];
}

main();

/**
 * 1, 2, 3, 4, 5, 6, ...
 * 1, 3, 6,
 * 1, 4, 10 
 */