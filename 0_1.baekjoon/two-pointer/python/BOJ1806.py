from sys import stdin
readline = stdin.readline

N, S = map(int, readline().split())
arr = list(map(int, readline().split()))
INF = float('inf')

def solve():
    left, curr, ans = 0, 0, INF

    for right in range(N):
        curr += arr[right]

        while left < right and curr - arr[left] >= S:
            curr -= arr[left]
            left += 1
        
        if curr >= S and ans > right - left:
            ans = right - left
        
    print(ans + 1 if ans != INF else 0)

solve() 


