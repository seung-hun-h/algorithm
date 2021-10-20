# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # write your code in Python 3.6
    prefix_sum = [A[0]]
    for i in range(1, len(A)):
        prefix_sum.append(prefix_sum[i-1]+A[i])
    
    _min = float('inf')
    ans = 0

    for i in range(1, len(prefix_sum)):
        mean = (prefix_sum[i] - prefix_sum[i-1] + A[i-1]) / 2

        if _min > mean:
            _min = mean
            ans = i - 1
        
        if i - 2 < 0: continue

        mean = (prefix_sum[i] - prefix_sum[i-2] + A[i-2]) / 3

        if _min > mean:
            _min = mean
            ans = i - 2
    return ans
print(solution([10, 10, -1, 2, 4, -1, 2, -1]))