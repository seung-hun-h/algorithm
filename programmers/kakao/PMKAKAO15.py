from collections import Counter
def solution(N, stages):
    counter = Counter(stages)
    fails = {}

    cur = len(stages)
    for i in range(1, N+1):
        if cur != 0:
            fails[i] = counter[i] / cur
            cur -= counter[i]
        else:
            fails[i] = 0
    return sorted(fails, key=lambda x: fails[x], reverse=True)
N = 5
arr = [2, 1, 2, 6, 2, 4, 3, 3]	
res = solution(N, arr)
print(res)