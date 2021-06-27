# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

from collections import Counter, defaultdict

def solution(A):
    # write your code in Python 3.6
    pre = defaultdict(int)
    pre_leader = None
    after = Counter(A)
    ans = 0
    for i in range(len(A)):
        pre[A[i]] += 1
        after[A[i]] -= 1

        if pre[A[i]] > (i+1) / 2:
            pre_leader = A[i]
        
        if after[pre_leader] > (len(A) - i - 1) / 2 and pre[pre_leader] > (i+1) / 2:
            ans += 1

    return ans