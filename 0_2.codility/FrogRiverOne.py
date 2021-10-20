# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(X, A):
    # write your code in Python 3.6

    leaves = set()
    for time, leaf in enumerate(A):
        if leaf <= X:
            leaves.add(leaf)

        if len(leaves) == X:
            return time
    return -1