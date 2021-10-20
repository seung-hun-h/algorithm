from sys import stdin
import collections

readline = stdin.readline

N, K = map(int, readline().split())
coins = sorted([int(readline()) for _ in range(N)], reverse=True)

def solve():
    global K
    count = 0
    for coin in coins:
        if K < coin: continue
        count += (K // coin)
        K %= coin
    print(count)

solve()