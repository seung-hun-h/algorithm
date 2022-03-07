const fs = require('fs');
const input = fs.readFileSync('input.txt').toString();

(function main() {
    const [x, y, w, h] = input.split(' ').map(x => parseInt(x));
    console.log(Math.min(Math.min(x, w - x), Math.min(y, h - y)));
})();

