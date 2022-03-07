const fs = require('fs');
const input = fs.readFileSync('input.txt').toString().split('\n');

class Queue {
    constructor() {
        this.items = [];
        this.head = 0;
        this.rear = 0;
    }

    static of(array) {
        const queue = new Queue();
        for (let item of array) {
            queue.push(item);
        }   
        
        return queue;
    }

    isEmpty() {
        return this.size() === 0;
    }

    size() {
        return this.rear - this.head;
    }

    poll() {
        if (this.isEmpty()) {
            return undefined;
        }

        const first = this.items[this.head];
        this.head++;
        return first;
    }

    peek() {
        return this.items[this.head];
    }

    put(item) {
        this.items.push(item);
        this.rear++;
    }

    existWeighterThan(target) {
        for (let i = this.head + 1; i < this.rear; i++) {
            if (this.items[i].weight > target.weight) {
                return true;
            }
        }

        return false;
    }

}

function Document(idx, weight) {
    this.idx = idx,
    this.weight = weight;
}

(function main(){
    const T = +input[0];

    let answer = "";

    for (let i = 0; i < T; i++) {
        const idx = 2 * i + 1;
        const [N, M] = input[idx].split(' ').map(x => +x);
        const array = input[idx + 1].split(' ').map(x => +x);

        answer += `${solve(N, M, array)}\n`;
    }

    console.log(answer);

})();

function solve(N, M, array) {
    const queue = new Queue();
    let count = 0;
    for (let idx in array) {
        queue.put(new Document(+idx, array[idx]));
    }

    while (!queue.isEmpty()) {
        const document = queue.peek();
        
        if (queue.existWeighterThan(document)) {
            queue.put(queue.poll());
        } else {
            queue.poll();
            count++;
            if (document.idx === M) {
                return count;
            }
        }
    }

}

