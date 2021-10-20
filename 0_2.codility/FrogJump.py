# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(X, Y, D):
    # write your code in Python 3.6
    Y -= X
    result = Y // D
    result += 1 if Y > D*result else 0

    return result