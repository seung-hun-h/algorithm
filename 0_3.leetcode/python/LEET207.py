from typing import *
import collections

def canFinish(numCourses: int, prerequisites: List[List[int]]) -> bool:
    def dfs(i) -> bool:
        
        if i in traced:
            return False

        if i in visited:
            return True

        traced.add(i)
        for v in graph[i]:
            if not dfs(v):
                return False
        
        traced.remove(i)
        visited.add(i)
    
        return True

    graph = collections.defaultdict(list)
    
    for u, v in prerequisites:
        graph[u].append(v)

    visited = set()
    traced = set()

    for x in list(graph):
        if not dfs(x):
            return False
    return True

canFinish(numCourses = 2, prerequisites = [[1,0]])

