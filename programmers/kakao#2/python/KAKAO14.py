from itertools import combinations
from collections import defaultdict
from bisect import bisect_left
def solution(info, queries):
    categories = categorize(info)
    
    for key in categories:
        categories[key].sort()
    
    answer = []
    for query in queries:
        query = query.replace("and", "").replace("-", "").split()
        score = int(query.pop())
        key = ''.join(query)
        
        scores = categories[key]
        if scores:
            answer.append(len(scores) - bisect_left(scores, score))
        else:
            answer.append(0)
            
    return answer

def categorize(infos):
    data = defaultdict(list)
    for info in infos:
        line = info.split()[:-1]
        score = int(info.split()[-1])
        for size in range(len(line)+1):
            for key in combinations(line, size):
                key = ''.join(key)
                data[key].append(score)
    return data

"""
[카카오 2021 공채 순위 검색]
해결: O
"""