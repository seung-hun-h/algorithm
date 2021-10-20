from sys import stdin
readline = stdin.readline

N, K = map(int, readline().split())
numbers = readline().rstrip()

def solve():
    global K
    stack = []
    for number in numbers:
        while stack and K and stack[-1] < number:
            stack.pop()
            K -= 1
        stack.append(number)
    
    while K:
        stack.pop()
        K -= 1

    print(''.join(stack))
solve()