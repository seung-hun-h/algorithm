from sys import stdin
import heapq

readline = stdin.readline


def main():
    n, k = map(int, readline().split())
    coins = [int(readline()) for _ in range(n)]    
    print(greedy_solve(k, coins))
    print(dp_solve(n, k, coins))


def dp_solve(n, k, coins):
    d = [10001] * (k+1)
    d[0] = 0
    for i in range(n):
        for j in range(coins[i], k+1):
            d[j] = min(d[j], d[j-coins[i]] + 1)

    if d[k] == 10001:
        return -1
    return d[k]

def greedy_solve(k, coins):
    pq = []
    heapq.heappush(pq, [0, k])
    visited = set()
    while pq:
        d, cur = heapq.heappop(pq)

        if cur == 0:
            return d

        for coin in coins:
            if cur - coin > 0 and cur - coin not in visited:
                heapq.heappush(pq, [d+1, cur-coin])
                visited.add(cur-coin)
            elif cur - coin == 0:
                return d + 1
    return -1

if __name__ == "__main__":
    main()