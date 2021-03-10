from sys import stdin
readline = stdin.readline

def network_size():
    treeSize = dict()
    parent = dict()
    for _ in range(int(readline().strip())):
        u, v = readline().split()
        if u not in treeSize.keys():
            treeSize[u] = 1
            parent[u] = u
        if v not in treeSize.keys():
            treeSize[v] = 1
            parent[v] = v
        
        if findSet(parent, u) != findSet(parent, v):
            print(treeSize[findSet(parent, u)] + treeSize[findSet(parent, v)])
            union(parent, treeSize, u, v)
        else:
            print(treeSize[findSet(parent, u)])

def findSet(parent, u):
    while u != parent[u]:
        parent[u] = parent[parent[u]]
        u = parent[u]
    return parent[u]

def union(parent, treeSize, u, v):
    x = findSet(parent, u)
    y = findSet(parent, v)

    if treeSize[x] > treeSize[y]:
        parent[y] = x
        treeSize[x] += treeSize[y]
    else:
        parent[x] = y
        treeSize[y] += treeSize[x]
        

if __name__ == "__main__":
    T = int(readline().strip())
    for _ in range(T):
        network_size()