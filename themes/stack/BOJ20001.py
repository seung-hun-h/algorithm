from sys import stdin
readline = stdin.readline

def solve():
    readline()
    stack = []
    while True:
        line = readline().strip().split()
        if len(line) > 1:
            break
        
        if line[0] == "문제":
            stack.append(1)
        else:
            if not stack:
                stack.append(1)
                stack.append(1)
            else:
                stack.pop()

    if not stack:
        print('고무오리야 사랑해')
    else:
        print('힝구')
solve()