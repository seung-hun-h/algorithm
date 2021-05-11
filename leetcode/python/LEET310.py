from typing import *
import collections

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def findMinHeightTrees(n: int, edges: List[List[int]]) -> List[int]:
    if n <= 1:
        return [0]
    graph = collections.defaultdict(list)
    for u, v in edges:
        graph[u].append(v)
        graph[v].append(u)

    leaves = [i  for i in range(n) if len(graph[i]) == 1]

    while n > 2:
        n -= len(leaves)
        new_leaves = []
        for leaf in leaves:
            neighbor = graph[leaf].pop()
            graph[neighbor].remove(leaf)

            if len(graph[neighbor]) == 1:
                new_leaves.append(neighbor)
        
        leaves = new_leaves

    return leaves
res = findMinHeightTrees(n = 4, edges = [[1,0],[1,2],[1,3]])
print(res)