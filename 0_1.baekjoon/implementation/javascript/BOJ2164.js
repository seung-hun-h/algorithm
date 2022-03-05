const fs = require('fs');
const input = fs.readFileSync('input.txt').toString();

class Deque {
    constructor() {
        this.count = 0;
        this.items = [];
        this.head = 0;
    }

    static from(values) {
        const deque = new Deque();
        // todo push value

        for (let value of values) {
            deque.pushLast(value);
        }

        return deque;
    }

    isEmpty() {
        return this.size() === 0;
    }

    size() {
        return this.count - this.head;
    }

    pushLast(value) {
        this.items.push(value);
        this.count++;
    }

    removeFirst() {
        if (this.isEmpty()) {
            return undefined;
        }

        const first = this.items[this.head];
        this.items[this.head] = undefined;
        this.head++;
        return first;
    }

    peekFirst() {
        return this.items[this.head];
    }

    toString() {
        let result = "";
        for (let item of this.items) {
            result += `${item} `;
        }

        return result;
    }
}

function main() {
    const deque = Deque.from([...Array(+input).keys()].map(num => num + 1));

    while(deque.size() > 1) {
        // 맨 앞 제거
        deque.removeFirst();

        deque.pushLast(deque.removeFirst());
    }

    console.log(deque.peekFirst());
}
main();