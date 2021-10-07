from sys import stdin
from collections import Counter
readline = stdin.readline

N, d, k, c = map(int, readline().split())

belt = [int(readline().strip()) for _ in range(N)]

def solve():
    global d

    if N <= k:
        if c not in belt:
            d += 1
        print(d)
        return

    counter = Counter(belt[:k])
    ans = len(counter)
    left, right = 0, k
    kind = ans

    for _ in range(N - 1):
        counter[belt[left]] -= 1
        if counter[belt[left]] == 0:
            kind -= 1

        counter[belt[right]] += 1
        if counter[belt[right]] == 1:
            kind += 1

        coupon = 1 if counter[c] == 0 else 0

        ans = max(ans, kind + coupon)

        left = (left + 1) % N
        right = (right + 1) % N

    print(ans)
solve()