import collections
def solution(N, stages):
    counter = collections.Counter(stages)
    
    result = []
    M = len(stages)
    for stage in range(1, N+1):
        if stage not in counter:
            result.append([stage, 0])
        else:
            result.append([stage, counter[stage] / M])
            M -= counter[stage]
            
    return [r[0] for r in sorted(result, key=lambda x: -x[1])]

"""
[카카오 2019 공채] 실패율
해결: O
시간: 35분
명확하게 설계하고 구현해아 시간을 단축시킬 수 있을 듯
"""