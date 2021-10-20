from sys import stdin
readline = stdin.readline

N = int(readline())
arr = sorted(list(map(int, readline().split())))

def solve():
    left, right = 0, N-1
    _min = float('inf')
    ans = []

    while left < right:
        result = arr[left] + arr[right]
        if abs(result) < _min:
            _min = abs(result)
            ans = [arr[left], arr[right]]

        if result < 0:
            left += 1
        elif result > 0:
            right -= 1
        else:
            break

    print(*ans)

solve()

"""
해결: O
시간: 15분
"""