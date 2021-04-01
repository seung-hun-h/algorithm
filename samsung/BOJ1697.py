from sys import stdin
from collections import deque
readline = stdin.readline

N, K = map(int, readline().split())
MAX = int(1e5)
visited = [False for _ in range(MAX+1)]
visited[N] = True
def solve():
    q = deque()
    q.append([N, 0])

    while q:
        cur, cnt = q.popleft()

        if cur == K:
            return cnt
        
        front = cur + 1
        back = cur - 1
        double = cur * 2

        if front <= MAX and not visited[front]:
            visited[front] = True
            q.append([front, cnt + 1])

        if 0<= back and not visited[back]:
            visited[back] = True
            q.append([back, cnt + 1])

        if double <= MAX and not visited[double]:
            visited[double] = True
            q.append([double, cnt + 1])


print(solve())