from itertools import combinations
from collections import Counter
def solution(orders, course):
    result = []
    for c in course:
        _list = []
        for order in orders:
            if len(order) < c: continue
            _list += list(map(''.join, combinations(sorted(order), c)))
        if not _list: continue
        
        most = Counter(_list).most_common()
        result += [k for k, v in most if v > 1 and v == most[0][1]]        
    return sorted(result)
res = solution(["XYZ", "XWY", "WXA"], [2,3,4])
print(res)