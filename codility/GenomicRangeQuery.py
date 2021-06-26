# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(S, P, Q):
    # write your code in Python 3.6

    impact_factor = {
        'A': 1,
        'C': 2,
        'G': 3,
        'T': 4
    }

    result = [[0] * 4]
    ans = []
    for i, nucletide in enumerate(S):
        current = result[i][:]
        current[impact_factor[nucletide]-1] += 1

        result.append(current)

    for p, q in zip(P, Q):
        current = result[q+1][:]

        if p == q:
            ans.append(impact_factor[S[p]])
            continue

        for i in range(4):
            current[i] -= result[p][i]
            
            if current[i] != 0:
                ans.append(i+1)
                break
        
    return ans

print(solution('AC', [0, 0, 1], [0, 1, 1]))
"""
해결: X
"""