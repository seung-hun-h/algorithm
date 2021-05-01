from collections import defaultdict
from itertools import combinations
from bisect import bisect_left, bisect_right
def solution(info, query):
    answer = []
    scores = defaultdict(list)

    # 가능한 모든 query에 대한 score 저장
    for i in range(len(info)):
        _info = info[i].split()
        keys = _info[:-1]
        score = _info[-1]

        for size in range(len(keys)+1):
            for key in combinations(keys, size):
                scores[''.join(key)].append(int(score))

    # binary search를 위한 정렬
    for key in scores:
        scores[key].sort()

    for q in query:
        _list = q.replace('and', '').replace('-', '').split()
        target = int(_list[-1])
        q = ''.join(_list[:-1])
   
        answer.append(len(scores[q])-bisect_left(scores[q], target))
    return answer
info = ["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"]
query = ["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]
res = solution(info, query)
print(res)