const fs = require('fs');
const input = fs.readFileSync('input.txt').toString().split('\n');

function main() {
    const N = +input[0]
    let answer = ''
    const members = input.slice(1, N + 1).map(x => {
        const [age, name] = x.split(' ');
        return [parseInt(age), name];
    }).sort((a, b) => {
        if (a[0] !== b[0]) {
            return a[0] - b[0];
        } else {
            return 1;
        }
    }).forEach(x => answer += x.join(' ') + '\n');
    
    console.log(answer);
}

main();