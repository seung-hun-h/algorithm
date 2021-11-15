from sys import stdin
from collections import defaultdict
readline = stdin.readline

x_dict = defaultdict(list)
y_dict = defaultdict(list)

N, C = map(int, readline().split())


for _ in range(N):
    x, y, v = map(int, readline().split())

    x_dict[x].append((x, y, v))
    y_dict[y].append((x, y, v))

def solve():
    ans = 0
    x_limit, y_limit, count, current = 0, 100000, 0, 0

    while x_limit <= 100000:
        for x, y, v in x_dict[x_limit]:
            if y > y_limit: continue
            count += 1
            current += v

        while count > C:
            for x, y, v in y_dict[y_limit]:

                if x > x_limit: continue

                count -= 1
                current -= v
                
            y_limit -= 1

        x_limit += 1
        ans = max(ans, current)

    print(ans)

solve()
