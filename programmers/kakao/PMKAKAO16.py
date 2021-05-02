from collections import Counter
from itertools import combinations
def solution(relation):
    answer = 0
    idx = [i for i in range(len(relation[0]))]
    candidate_key = set()
    for size in range(1, len(relation[0])+1):
        for key_set in combinations(idx, size):
            key = "".join(map(str, key_set))
            # minimality
            flag = False
            for candidate in candidate_key:
                if key.count(candidate):
                    flag = True
                    break
            if flag: continue

            # unigqueness
            counter = Counter([''.join([r[k] for k in key_set]) for r in relation])
            if counter.most_common(1)[0][1] == 1:
                answer += 1
                candidate_key.add(key)
        
    return answer
res = solution([["100","ryan","music","2"],["200","apeach","math","2"],["300","tube","computer","3"],["400","con","computer","4"],["500","muzi","music","3"],["600","apeach","music","2"]])
print(res)