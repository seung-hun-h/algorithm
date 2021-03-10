from sys import stdin

readline = stdin.readline

def get_min_price():
    path = []
    cost = 0
    pred = [i for i in range(N+1)]
    idx = 0
    while len(path) != N-1 and idx < M:
        u, v, c = edges[idx]

        if findSet(pred, u) != findSet(pred ,v):
            union(pred, u, v)
            cost += c
            path.append([u, v, c])
        idx += 1

    # path.sort(key=lambda x:x[2], reverse=True)
    print(cost - path[len(path)-1][2])

def findSet(pred, n):
    while n != pred[n]:
        pred[n] = pred[pred[n]]
        n = pred[n]
    return pred[n]

def union(pred, u, v):
    x = findSet(pred, u)
    y = findSet(pred, v)

    if treeSize[x] > treeSize[y]:
        pred[y] = x
        treeSize[x] += treeSize[y]
    else:
        pred[x] = y
        treeSize[y] += treeSize[x]
    

if __name__=="__main__":
    N, M = map(int, readline().split())
    edges = [list(map(int, readline().split())) for _ in range(M)]
    edges.sort(key=lambda x:x[2])
    treeSize = [1] * (N+1)
    get_min_price()
