from sys import stdin
from collections import deque
readline = stdin.readline

def get_ys_seq():
    idx = K - 1
    stack = [i+1 for i in range(N)]
    result = []

    for _ in range(N):
        if len(stack) <= idx:
            idx %= len(stack)

        result.append(stack.pop(idx))
        idx += K - 1

    return result 

if __name__ == "__main__":
    N, K = map(int, readline().split())
    print("<"+", ".join(list(map(str, get_ys_seq())))+">")