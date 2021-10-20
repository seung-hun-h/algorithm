from collections import defaultdict, Counter
from itertools import combinations

def solution(relation):
    candidates = set()
    for size in range(1, len(relation[0]) + 1):
        for key_index in combinations(range(len(relation[0])), size):
            counter = Counter()
            for _tuple in relation:
                key = ''.join([str(_tuple[idx]) for idx in key_index])
                counter[key] += 1
                
            if counter.most_common(1)[0][1] == 1:
                temp = ''.join(list(map(str, key_index)))
                
                possible = True
                for candidate in candidates:
                    if len(set(candidate) & set(temp)) == len(candidate):
                        possible = False
                        break
                if possible:
                    candidates.add(temp)
    return len(candidates)
"""
[카카오 2019 공채] 후보키
해결: O
시간: 26분
"""