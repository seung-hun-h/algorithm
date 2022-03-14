const fs = require('fs');
const input = fs.readFileSync('input.txt').toString().split('\n');

class Heap {
    constructor() {
        this.heap = [-1];
    }

    getLeftIndex(index) {
        return 2 * index;
    }

    getRightIndex(index) {
        return 2 * index + 1;
    }

    getParentIndex(index) {
        if (index === 1) {
            return undefined;
        }
        return Math.floor(index / 2);
    }

    size() {
        return this.heap.length - 1;
    }

    isEmpty() {
        return this.size() === 0;
    }

    insert(value) {
        if (value === null) {
            return false;
        }
        this.heap.push(value);
        this.shiftUp(this.size());
        return true;
    }

    shiftUp(index) {
        let parent = this.getParentIndex(index);
        while(index > 1 && this.heap[index] < this.heap[parent]) {
            this.swap(index, parent);
            index = parent;
            parent = this.getParentIndex(index);
        }
    }

    shiftDown(index) {
        let element = index;
        const left = this.getLeftIndex(index);
        const right = this.getRightIndex(index);
        const size = this.size();
        if (left <= size && this.heap[element] > this.heap[left]) {
            element = left;
        }

        if (right <= size && this.heap[element] > this.heap[right]) {
            element = right;
        }

        if (index !== element) {
            this.swap(index, element);
            this.shiftDown(element);
        }
    }

    swap(idx1, idx2) {
        [this.heap[idx1], this.heap[idx2]] = [this.heap[idx2], this.heap[idx1]];
    }

    extract() {
        if (this.isEmpty()) {
            return undefined;
        }
        const removedValue = this.heap[1];
        const temp = this.heap.pop();
        if (!this.isEmpty()) {
            this.heap[1] = temp;
            this.shiftDown(1);
        }
        return removedValue;
    }
}

function main() {
    const N = +input[0]
    const array = input.slice(1, N + 1).map(x => +x);
    const heap = new Heap();
    let answer = "";
    for (let idx in array) {
        const num = array[idx];

        if (num === 0) {
            const value = heap.extract() || 0;
            answer += `${value}\n`;
        } else {
            heap.insert(num);
        }
    }
    
    console.log(answer);
}

main();