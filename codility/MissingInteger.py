# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # write your code in Python 3.6
    A.sort()
    result = 1

    for num in A:
        if num > 0 and result == num:
            result += 1
    return result