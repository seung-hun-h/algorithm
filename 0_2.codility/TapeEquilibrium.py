# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # write your code in Python 3.6
    for i in range(1, len(A)):
        A[i] += A[i-1]
    result = float('inf')
    for i in range(len(A)-1):
        result = min(result, abs(A[-1] - (A[i]*2)))

    return result