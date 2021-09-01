from sys import stdin
readline = stdin.readline

N = int(readline())
arr = list(map(int, readline().split()))

def solve():
    _next = next_permutation(arr)

    print(' '.join(list(map(str, _next))) if _next else -1)

def next_permutation(array):
    copy = [array[i] for i in range(N)]

    idx = -1

    for i in range(N-1):
        if copy[i] < copy[i+1]:
            idx = i

    if idx == -1:
        return []

    for i in range(N-1, -1, -1):
        if copy[idx] < copy[i]:
            temp = copy[idx]
            copy[idx] = copy[i]
            copy[i] = temp
            break
    
    copy = copy[:idx+1] + copy[-1:idx:-1]
    return copy  

solve()