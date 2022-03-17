const fs = require("fs");
const input = fs.readFileSync('input.txt').toString().split('\n');

function main() {
    const N = +input[0];
    const array = input.slice(1, N + 1).map(x => x.split(' ').map(x => +x));

    let white = 0;
    let blue = 0;

    const divideConquer = function (row, col, n) {
        const blueCount = countBlue(row, col, n);
        if (blueCount === 0) {
            white++;
        } else if (blueCount === n * n) {
            blue++;
        } else {
            const half = parseInt(n / 2);
            divideConquer(row, col, half);
            divideConquer(row + half, col, half);
            divideConquer(row, col + half, half);
            divideConquer(row + half, col + half, half);
        }
    }

    const countBlue = function(row, col, n) {
        let result = 0;
        for (let i = row; i < row + n; i++) {
            for (let j = col; j < col + n; j++) {
                if (array[i][j]) {
                    result++;
                }
            }
        }

        return result;
    }

    divideConquer(0, 0, N);
    console.log(`${white}\n${blue}`);
    
}

main();