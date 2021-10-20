from sys import stdin
readline = stdin.readline

string = readline().strip()
bomb = readline().strip()

def solve():
    stack = []
    for s in string:
        stack.append(s)

        if s == bomb[-1] and len(stack) >= len(bomb):
            if ''.join(stack[-len(bomb):]) == bomb:
                for _ in range(len(bomb)):
                    stack.pop()
    
    print(''.join(stack) if stack else "FRULA")
solve()