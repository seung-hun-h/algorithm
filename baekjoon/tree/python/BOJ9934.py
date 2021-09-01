from sys import stdin
from collections import defaultdict
readline = stdin.readline

K = int(readline())
buildings = list(map(int, readline().split()))

def solve():
    levels = defaultdict(list)
    dfs(buildings, 0, levels)
    
    for level in sorted(levels):
        print(*levels[level])

def dfs(buildings, level, levels):
    if not buildings:
        return
    mid = len(buildings) // 2
    
    node = buildings[mid]
    levels[level].append(node)

    dfs(buildings[:mid], level+1, levels)
    dfs(buildings[mid+1:], level+1, levels)
solve()