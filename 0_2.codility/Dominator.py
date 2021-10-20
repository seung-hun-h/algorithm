# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

from collections import Counter

def solution(A):
    # write your code in Python 3.6
    if not A:
        return -1

    counter = Counter(A)

    key, value = counter.most_common(1)[0]

    return A.index(key) if value > len(A) / 2 else -1
