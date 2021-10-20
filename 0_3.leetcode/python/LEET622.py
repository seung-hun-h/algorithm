class MyCircularQueue:

    def __init__(self, k: int):
        self.q = [None] * k
        self.max_len = k
        self.front = 0
        self.rear = 0        

    def enQueue(self, value: int) -> bool:
        if self.q[self.rear] is None:
            self.q[self.rear] = value
            self.rear = (self.rear + 1) % self.max_len
            return True
        return False

    def deQueue(self) -> bool:
        if self.q[self.front] is None:
            return False
        
        self.q[self.front] = None
        self.front = (self.front + 1) % self.max_len
        return True

    def Front(self) -> int:
        return -1 if self.q[self.front] is None else self.q[self.front]
        
    def Rear(self) -> int:
        return -1 if self.q[self.rear-1] is None else self.q[self.rear-1]

    def isEmpty(self) -> bool:
        return self.front == self.rear and self.q[self.front] is None
        
    def isFull(self) -> bool:
        return self.front == self.rear and self.q[self.front] is not None

def solve():
    q = MyCircularQueue(5)
    q.enQueue(1)
    q.enQueue(2)
    q.enQueue(3)
    q.enQueue(4)
    q.enQueue(5)
    q.deQueue()
    q.deQueue()
    q.deQueue()
    q.deQueue()
    print(q.q) 
    print(q.front)
    print(q.Rear())
solve()