from sys import stdin

readline = stdin.readline

class MySet:
    def __init__(self):
        self._set = [0] * 21

    def add(self, num):
        self._set[num] = 1
    def remove(self, num):
        self._set[num] = 0
    def check(self, num):
        return self._set[num]
    def toggle(self, num):
        self._set[num] = (self._set[num] + 1) % 2
    def all(self):
        self._set = [1] * 21
    def empty(self):
        self._set = [0] * 21

def main():
    my_set = MySet()
    C = int(readline().strip())

    for _ in range(C):
        com = readline().split()
        if com[0] == "add":
            my_set.add(int(com[1]))
        elif com[0] == "remove":
            my_set.remove(int(com[1]))
        elif com[0] == "check":
            print(my_set.check(int(com[1])))
        elif com[0] == "toggle":
            my_set.toggle(int(com[1]))
        elif com[0] == "all":
            my_set.all()
        else:
            my_set.empty()

if __name__=="__main__":
    main()