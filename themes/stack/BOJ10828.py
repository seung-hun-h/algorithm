from sys import stdin
from collections import deque
readline = stdin.readline
class my_stack:
    def __init__(self):
        self.q = deque()

    def push(self, val):
        self.q.append(val)

        for _ in range(len(self.q)-1):
            self.q.append(self.q.popleft())

    def pop(self):
        return self.q.popleft() if self.q else -1

    def size(self):
        return len(self.q)

    def empty(self):
        return 1 if not self.q else 0
    
    def top(self):
        return -1 if not self.q else self.q[0]

N = int(readline())
def solve():
    stack = my_stack()
    for _ in range(N):
        command = readline().split()

        if command[0] == "push":
            stack.push(int(command[1]))
        elif command[0] == "pop":
            print(stack.pop())
        elif command[0] == "top":
            print(stack.top())
        elif command[0] == "size":
            print(stack.size())
        else:
            print(stack.empty())

solve()