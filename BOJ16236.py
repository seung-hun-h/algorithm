from sys import stdin
import heapq
readline = stdin.readline

N = int(readline())
shark = [] # 최소 거리를 구해야 하기 때문에 BFS를 사용한다.
fish = [0] * 7
_map = [[0] * N for _ in range(N)]

# 우선: 위
# 차선: 왼
dr = (-1, 0, 1, 0)
dc = (0, -1, 0, 1)

for r in range(N):
    line = list(map(int, readline().split()))
    for c in range(N):
        if line[c] == 9:
            heapq.heappush(shark, [0, r, c, 2, 0]) # 이동횟수, row, col, 사이즈, 먹은 물고기 수
        elif line[c] != 0:
            _map[r][c] = line[c]
            fish[line[c]] += 1

def solve():
    global shark

    moves = 0
    visited = [[False] * N for _ in range(N)]
    
    while shark:
        m, r, c, s, f = heapq.heappop(shark)
        visited[r][c] = True
        
        # 먹을 수 있는 물고기일 경우
        if _map[r][c] != 0 and _map[r][c] < s:            
            _map[r][c] = 0
            fish[_map[r][c]] -= 1
            f += 1
            # 사이즈 증가인 경우
            if f == s:
                s += 1
                f = 0

            moves = m

            # 물고기를 먹은 위치에 도달
            # 셀 방문 기록과 큐를 초기화
            shark = []
            visited = [[False] * N for _ in range(N)]

            # 더이상 먹을 수 있는 물고기가 없을 경우 종료
            temp = 0
            for i in range(7):
                if i < s:
                    temp += fish[i]
            if not temp: break


        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]
            if 0<=nr<N and 0<=nc<N and _map[nr][nc] <= s and not visited[nr][nc]:
                heapq.heappush(shark, [m+1, nr, nc, s, f])
                visited[nr][nc] = True
        

    print(moves)

solve()