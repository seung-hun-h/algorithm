from sys import stdin
readline = stdin.readline

N, M, B = map(int, readline().split())
cnt = [0] * 257
_max = 0

for _ in range(N):
    line = list(map(int, readline().split()))
    for i in range(M):
        cnt[line[i]] += 1
        _max = max(_max, line[i]) # 최대 높이를 구해 최적화 한다.

def solve():
    time = 99999999999999999999999999
    height = 0
    for h in range(_max+1):
        lower = higher = 0

        for i in range(0, h):
            lower += (h-i)*cnt[i]

        for i in range(h+1, _max+1):            
            higher += (i-h)*cnt[i]

        # 제거해야 할 블럭의 개수가
        # 가지고있던 블럭과 새롭게 얻은 블럭 보다 이하인 경우
        if higher+B >= lower:
            current = higher*2 + lower
            if current <= time:
                time = current
                height = h

    print(time, height)

solve()