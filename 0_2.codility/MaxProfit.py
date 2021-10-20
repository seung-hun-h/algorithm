# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # write your code in Python 3.6
    if not A:
        return 0
    ans = -float('inf')
    min_stock = A[0]

    for i in range(1, len(A)):
        ans = max(ans, A[i] - min_stock)

        min_stock = min(min_stock, A[i])

    return ans if ans > 0 else 0