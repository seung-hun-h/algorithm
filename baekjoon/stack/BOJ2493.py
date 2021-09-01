from sys import stdin
readline = stdin.readline

N = int(readline())
height = list(map(int, readline().split()))

def solve():
    stack = []
    recieve = [0] * N

    for i in range(N):
        while stack and height[stack[-1]] < height[i]:
            stack.pop()
        if stack and height[stack[-1]] >= height[i]:
            recieve[i] = stack[-1] + 1
        stack.append(i)
    print(*recieve)
solve()