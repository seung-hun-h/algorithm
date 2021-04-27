from sys import stdin
readline = stdin.readline

T = int(readline())

def solve():
    for _ in range(T):
        left, right = [], []
        line = readline().strip()
        
        for x in line:
            if x.isalnum():
                left.append(x)
            elif x == "-":
                if left:
                    left.pop()
            elif x == "<":
                if left:
                    right.append(left.pop())
            else:
                if right:
                    left.append(right.pop())

        print(''.join(left+right[::-1]))
            
solve()