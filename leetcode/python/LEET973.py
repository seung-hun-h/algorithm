from typing import *
import heapq

def kClosest(points: List[List[int]], k: int) -> List[List[int]]:
    result = sorted(points, key = lambda point: point[0]**2 + point[1]**2)
    return result[:k]

ans = kClosest(points = [[3,3],[5,-1],[-2,4]], k = 2)
print(ans)