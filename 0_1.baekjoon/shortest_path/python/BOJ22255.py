from sys import stdin  
import heapq

readline = stdin.readline
N, M = map(int, readline().split())

s_row, s_col, e_row, e_col = map(int, readline().split())

board = [list(map(int, readline().split())) for _ in range(N)]
D = (((-1, 0), (0, 1), (1, 0), (0, -1)), ((-1, 0), (1, 0)), ((0, -1), (0, 1)))

INF = float('inf')

def solve():

    dist = [[[INF for _ in range(3)] for _ in range(M)] for _ in range(N)]
    
    pq = [(0, s_row - 1, s_col - 1, 0)]
    dist[s_row - 1][s_col - 1][0] = 0

    while pq:
        amount, row, col, count = heapq.heappop(pq)

        if dist[row][col][count] < amount: continue
        
        new_count = (count + 1) % 3
        for dr, dc in D[new_count]:
            nr, nc = row + dr, col + dc

            if 0 <= nr < N and 0 <= nc < M and board[nr][nc] != -1:
                alt = amount + board[nr][nc]

                if (dist[nr][nc][new_count] > alt):
                    dist[nr][nc][new_count] = alt
                    heapq.heappush(pq, (alt, nr, nc, new_count))
    
    ans = min(dist[e_row - 1][e_col - 1])
    print(ans if ans != INF else -1)

solve()