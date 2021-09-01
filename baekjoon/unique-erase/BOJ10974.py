from sys import stdin
readline = stdin.readline

N = int(readline())
arr = [i+1 for i in range(N)]

def solve():
    permutation = []
    get_permutation(arr, [], permutation)

def get_permutation(array, result, results):
    if len(result) == N:
        print(*result)

    for i in range(len(array)):
        get_permutation(array[:i]+array[i+1:], result + [array[i]], results)

solve()