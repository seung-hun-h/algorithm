from sys import stdin
readline = stdin.readline

def check_set():
    for _ in range(m):
        c, u, v = map(int, readline().split()) 
        if c == 0:
            union(u, v)
        else:
            print('YES' if findSet(u) == findSet(v) else 'NO')

def findSet(u):
    while u != pred[u]:
        pred[u] = pred[pred[u]]
        u = pred[u]
    return pred[u]

def union(u, v):
    x = findSet(u)
    y = findSet(v)
    if treeSize[x] > treeSize[y]:
        pred[y] = x
        treeSize[x] += treeSize[y]
    else:
        pred[x] = y
        treeSize[y] += treeSize[x]

if __name__ == "__main__":
    n, m = map(int, readline().split())
    pred = [i for i in range(n+1)]
    treeSize = [1] * (n+1)
    check_set()