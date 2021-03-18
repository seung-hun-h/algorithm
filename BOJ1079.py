from sys import stdin
import heapq
readline = stdin.readline

INF = -1e6

N = int(readline())
scores = list(map(int, readline().split()))
arr = [list(map(int, readline().split())) for _ in range(N)]
eunjin = int(readline())
ans = 0

def solve():
    q = []
    for i in range(N):
        heapq.heappush(q, scores[i])

    dfs(N, 0,)

def dfs(remain, nights):
    global ans
    if remain == 1:
        ans = max(ans, nights)
        return
    
    if remain % 2 == 0:
        for i in range(N):
            if i != eunjin and scores[i] != INF:
                temp = scores[i]
                # 시민 죽임
                scores[i] = INF
                # 유죄 지수 적용
                for j in range(N):
                    if j != i and scores[j] != INF:
                        scores[j] += arr[i][j]
                
                solve(remain-1, nights+1)
                
                scores[i] = temp
                for j in range(N):
                    if j != i and scores[j] != INF:
                        scores[j] -= arr[i][j]

    else:
        # 유죄 지수 가장 높은 인원 선별
        _max = INF
        target = 0
        for i in range(N):
            if scores[i] != INF and _max < scores[i]:
                target = i
                _max = scores[i]

        if target == eunjin:
            ans = max(ans, nights)
            return
        # 유죄 지수 높은 인원 죽임
        scores[i] = INF        
        solve(remain-1, nights)

print(ans)