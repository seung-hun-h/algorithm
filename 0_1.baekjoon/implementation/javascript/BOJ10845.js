const fs = require('fs');
const input = fs.readFileSync('input.txt').toString().split('\n');

class Queue {
    constructor() {
        this.items = [];
        this.head = 0;
        this.count = 0;
    }

    empty() {
        return this.head === this.count ? 1 : 0;
    }

    size() {
        return this.count - this.head;
    }

    front() {
        if (this.empty()) {
            return -1;
        }

        return this.items[this.head];
    }

    back() {
        if(this.empty()) {
            return -1;
        }

        return this.items[this.items.length - 1];
    }

    pop() {
        if (this.empty()) {
            return -1;
        }

        const first = this.items[this.head];
        this.items[this.head] = undefined;
        this.head++;
        return first;
    }
 
    push(number) {
        this.items.push(number);
        this.count++;
    }
}
let answer = '';
function main() {
    const N = parseInt(input[0]);
    const queue = new Queue();
    for (let idx = 1; idx <= N; idx++) {
        execute(queue, input[idx].split(' ').map(x => x.trim()));
    }
    console.log(answer);
}

function execute(q, command) {
    if (command.length == 1) {
        switch(command[0]) {
            case 'front':
                answer += `${q.front()}\n`;
                break;
            case 'back':
                answer += `${q.back()}\n`;
                break;
            case 'size':
                answer += `${q.size()}\n`;
                break;
            case 'empty':
                answer += `${q.empty()}\n`;
                break;
            case 'pop':
                answer += `${q.pop()}\n`;
                break;
        }
    } else {
        q.push(+command[1]);
    }
}

main();