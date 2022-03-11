const fs = require('fs');
const input = fs.readFileSync('input.txt').toString().split('\n');

function main() {
    const [N, M] = input[0].split(' ').map(x => +x);

    const nameMap = new Map();
    const seqMap = new Map();

    input.slice(1, N + 1).forEach((name, seq) => {
        name = name.trim();
        nameMap.set(name, seq + 1);
        seqMap.set(seq + 1, name);
    });

    let answer = "";
    input.slice(N + 1, N + M + 1).forEach((query) => {
        query = query.trim();
        if (Number.isNaN(+query)) {
            answer += `${nameMap.get(query)}\n`;
        } else {
            answer += `${seqMap.get(+query)}\n`;
        }
    });

    console.log(answer);
}

main();