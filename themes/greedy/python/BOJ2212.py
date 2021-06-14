from sys import stdin
import collections
readline = stdin.readline

N, K = int(readline()), int(readline())
sensors = list(map(int, readline().split()))

def solve():
    sensors.sort()
    dist = sorted([sensors[i+1] - sensors[i] for i in range(len(sensors) - 1)], reverse=True)
    print(sum(dist[K-1:]))


solve()

"""
해결: x
시간: 50분
"""