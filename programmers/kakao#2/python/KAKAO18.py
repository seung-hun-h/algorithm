from collections import defaultdict

def solution(gems):
    start = 0
    gem_distinct = set(gems)
    result = [0, len(gems)]
    counter = defaultdict(int)
    
    for end in range(len(gems)):
    
        counter[gems[end]] += 1
    
        while len(counter) == len(gem_distinct):
            if end - start < result[1] - result[0]:
                result = [start+1, end+1]

            counter[gems[start]] -= 1

            if counter[gems[start]] == 0:
                del counter[gems[start]]

            start += 1
    
    return result

"""
[2020 카카오 인턴] 보석 쇼핑
해결: O
"""