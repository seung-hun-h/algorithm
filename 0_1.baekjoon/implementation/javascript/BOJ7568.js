const fs = require('fs');
const input = fs.readFileSync('input.txt').toString().split('\n');

function main() {
    const N = +input[0];
    const infos = input.slice(1, N + 1).map(info => info.split(' ').map(x => +x));
    let answer = "";
    for (let i in infos) {
        let count = 1;
        for (let j in infos) {
            if (i === j) continue;
            if (infos[i][0] < infos[j][0] && infos[i][1] < infos[j][1]) {
                count++;
            }
        }
        answer += `${count} `;
    }

    console.log(answer);
}

main();

