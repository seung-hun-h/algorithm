from typing import *
import collections
import heapq

def topKFrequent(nums: List[int], k: int) -> List[int]:
    freqs = collections.Counter(nums)
    heap = []
    for num, freq in freqs.items():
        heapq.heappush(heap, [-freq, num])

    res = []
    for _ in range(k):
        freq, num = heapq.heappop(heap)
        res.append(num)
    return res

def topKFrequent2(nums: List[int], k: int) -> List[int]:
    freqs = collections.Counter(nums)
    freqs_list = [[key, value] for key, value in freqs.items()]

    freqs_list.sort(key=lambda x: (-x[1]))

    return [freqs_list[i][0] for i in range( k if len(freqs_list) >= k else len(freqs_list))]

def topKFrequent3(nums: List[int], k: int) -> List[int]:
    return list(zip(*collections.Counter(nums).most_common(k)))[0]
res = topKFrequent3(nums = [1,1,1,2,2,3], k = 2)
print(res)