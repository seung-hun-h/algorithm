const fs = require('fs');
const input = fs.readFileSync("input.txt").toString().trim();

function main() {
    const N = +input;
    let result = "";

    for (let i = N - 1; i >= 0; i--) {
        const blank = " ".repeat(i);
        const stars = "*".repeat(N - i);
        result += blank + stars + "\n";
    }

    console.log(result);
}

main();