const fs = require('fs');
const input = fs.readFileSync('input.txt').toString();

function main() {
    const [bigger, smaller] = input.split(" ").map(x => parseInt(x)).sort().reverse();
    const _gcd = gcd(bigger, smaller);
    console.log(_gcd);
    console.log(lcm(bigger, smaller, _gcd));
}

function gcd(bigger, smaller) {
    return smaller ? gcd(smaller, bigger % smaller) : bigger;
}

function lcm(bigger, smaller, gcd) {
    return bigger * smaller / gcd;
}

main();