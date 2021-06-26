# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

import collections
def solution(A):
    # write your code in Python 3.6
    counter = collections.Counter(A)
    for key, value in counter.items():
        if value % 2 == 1:
            return key