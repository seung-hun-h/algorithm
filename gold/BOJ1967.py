from sys import stdin
from collections import deque

readline = stdin.readline

def is_possible():
    for i in range(N):
        line = list(map(int, readline().split()))
        for j in range(len(line)):
            if line[j] == 1:
                union(findSet(i+1), findSet(j+1))
    
    city = list(map(int ,readline().split()))
    for i in range(M-1):
        if findSet(city[i]) != findSet(city[i+1]):
            return False
    return True


def findSet(u):
    while u != parent[u]:
        parent[u] = parent[parent[u]]
        u = parent[u]
    return parent[u]

def union(u, v):
    x = findSet(u)
    y = findSet(v)

    if treeSize[x] > treeSize[y]:
        parent[y] = x
        treeSize[x] += treeSize[y]
    else:
        parent[x] = y
        treeSize[y] += treeSize[x]


if __name__ == '__main__':
    N = int(readline())
    M = int(readline())
    parent = [i for i in range(N+1)]
    treeSize = [1] * (N+1)
    print('YES' if is_possible() else 'NO')