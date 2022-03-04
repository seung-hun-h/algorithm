const fs = require('fs');
const input = fs.readFileSync("input.txt").toString().trim();

function main() {
    const [hour, minute] = input.split(" ").map(x => +x);

    let earlier = hour * 60 + minute - 45;

    if (earlier < 0) {
        earlier += 24 * 60
    }

    console.log(parseInt(earlier / 60), earlier % 60);   
}

main();