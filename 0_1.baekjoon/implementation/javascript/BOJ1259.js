const fs = require('fs');
const input = fs.readFileSync('input.txt').toString().split('\n');

function main() {
    let answer = "";
    let idx = 0;

    while (idx < input.length && +input[idx] !== 0) {
        if (isPalindrome(input[idx++].trim())) {
            answer += 'yes\n';
        } else {
            answer += 'no\n';
        }
    }

    console.log(answer);
}

function isPalindrome(sequence) {
    let left = 0, right = sequence.length - 1;

    while (left < right) {
        if (sequence[left] !== sequence[right]) {
            return false;
        }

        left++;
        right--;
    }

    return true;
}

main();