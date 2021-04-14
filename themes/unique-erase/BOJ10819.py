from sys import stdin
readline = stdin.readline

N = int(readline())
arr = list(map(int, readline().split()))
ans = 0


def solve():
    get_permutation(arr, [])

def get_permutation(array, result):
    global ans
    if len(result) == N:
        ans = max(ans, calculate(result))

    for i in range(len(array)):
        get_permutation(array[:i]+array[i+1:], result + [array[i]])

def calculate(array):
    res = 0
    for i in range(N-1):
        res += abs(array[i] - array[i+1])

    return res

solve()
print(ans)
