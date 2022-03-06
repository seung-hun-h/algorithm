const fs = require('fs');
const input = fs.readFileSync("input.txt").toString().split('\n');

function main() {
    const T = +input[0];
    let idx = 1;
    let answer = "";
    while(idx !== T + 1) {
        answer += `${assignRoom(input[idx++].split(" ").map(x => +x))}\n`;
    }
    console.log(answer);
}

function assignRoom([H, W, N]) {
    N--;
    const layer = N % H + 1
    const number = parseInt(N / H) < 9 ? `0${parseInt(N / H) + 1}` : `${parseInt(N / H) + 1}`
    return layer + number;
}

main();
/**
 * 1  - H
 * H+1 - 2H
 * 2H+1 - 3H
 * 3H+1 - 4H
 * (W-1)H+1 - WH
 * 
 * 1 2 3 4 5 0
 * 1 2 3 4 5 0
 * 1 2 3 4 5 0
 * 0 => H로 변환
 * H로 나눈 몫 + 1 == W
 *   
 */