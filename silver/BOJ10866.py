from sys import stdin, maxsize

readline = stdin.readline

class MyDeque:
    def __init__(self):
        self.deque = []

    def push_back(self, num):
        self.deque.append(num)

        return num
    
    def push_front(self, num):
        self.deque.insert(0, num)

        return num

    def front(self):
        if self.empty():
            return -1
    
        return self.deque[0]
    
    def back(self):
        if self.empty():
            return -1
    
        return self.deque[-1]
    
    def size(self):
        return len(self.deque)
    
    def empty(self):
        return 1 if self.size() == 0 else 0
    
    def pop_back(self):
        if self.empty():
            return -1
        val = self.deque[-1]
        del self.deque[-1]
        
        return val
    
    def pop_front(self):
        if self.empty():
            return -1
        val = self.deque[0]
        del self.deque[0]

        return val


def main():
    q = MyDeque()
    for _ in range(N):
        command = readline().split()
        
        if command[0] == "push_back":
            q.push_back(int(command[1]))
        elif command[0] == "push_front":
            q.push_front(int(command[1]))
        elif command[0] == "front":
            print(q.front())
        elif command[0] == "back":
            print(q.back())
        elif command[0] == "pop_front":
            print(q.pop_front())
        elif command[0] == "pop_back":
            print(q.pop_back())
        elif command[0] == "size":
            print(q.size())
        elif command[0] == "empty":
            print(q.empty())


if __name__ == "__main__":
    N = int(readline().strip())
    main()