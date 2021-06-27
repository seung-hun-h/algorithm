# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # write your code in Python 3.6
    head_sum = [0]
    tail_sum = [0] * len(A)

    """
    max(0, arg): 음수 구간은 제외
    """
    for i in range(1, len(A)-1):
        head_sum.append(max(0, head_sum[i-1] + A[i]))

    for i in range(len(A)-2, 0, -1):
        tail_sum[i] = max(0, tail_sum[i+1] + A[i])

    ans = 0
    for i in range(1, len(A)-1):
        ans = max(ans,  head_sum[i-1] + tail_sum[i+1])

    return ans
