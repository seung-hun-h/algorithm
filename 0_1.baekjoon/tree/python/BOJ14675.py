from sys import stdin
from collections import defaultdict
from copy import deepcopy
readline = stdin.readline

N = int(readline())
edges = [list(map(int, readline().split())) for _ in range(N-1)]
Q = int(readline())

def solve():
    _in = defaultdict(int)
    _out = defaultdict(int)
    child = set()
    for u, v in edges:
        child.add(v)
        _in[v] += 1
        _out[u] += 1
    for _ in range(Q):
        q, v = map(int, readline().split())
        if q == 1:
            if _in[v] + _out[v] >= 2:
                print('yes')
            else:
                print('no')
        else:
            print('yes')
solve()