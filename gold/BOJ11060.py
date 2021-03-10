from sys import stdin, maxsize
readline = stdin.readline

N = int(readline())
nums = [*map(int, readline().split())]
d = [maxsize for _ in range(N)]
d[0] = 0

for i in range(N):
    num = nums[i]
    for j in range(num+1):
        if i+j < N:
            d[i+j] = min(d[i+j], d[i] + 1)

if d[-1] == maxsize:
    print(-1)
else:
    print(d[-1])