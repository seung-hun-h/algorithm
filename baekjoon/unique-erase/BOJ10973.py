from sys import stdin
readline = stdin.readline

N = int(readline())
arr = list(map(int, readline().split()))

def solve():
    prev = prev_permutation()

    print(" ".join(list(map(str, prev))) if prev else -1)

def prev_permutation():
    copy = [arr[i] for i in range(N)]
    idx = N
    for i in range(N-1):
        if copy[i] > copy[i+1]:
            idx = i

    if idx == N:
        return []

    for i in range(N-1, -1, -1):
        if copy[idx] > copy[i]:
            tmp = copy[idx]
            copy[idx] = copy[i]
            copy[i] = tmp
            break

    copy = copy[:idx+1] + copy[-1:idx:-1]

    return copy
    

solve()