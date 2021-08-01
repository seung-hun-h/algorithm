from collections import deque

def solution(board):
    n = len(board)
    dr, dc = [0, 1, 0, -1], [1, 0, -1, 0]
    cache = [[-1 for _ in range(n)] for _ in range(n)]
    q = deque()
    
    q.append((0, 0, 0, 0))
    q.append((0, 0, 0, 1))
    
    while q:
        cost, row, col, _dir = q.popleft()
        
        for nd in range(4):
            nr, nc = row + dr[nd], col + dc[nd]

            if nr < 0 or nr >= n or nc < 0 or nc >= n:
                continue
            
            if board[nr][nc] == 1:
                continue
            
            if abs(_dir - nd) == 2:
                continue
            
            new_cost = cost + (100 if _dir == nd else 600)

            if cache[nr][nc] == -1 or new_cost <= cache[nr][nc]:
                cache[nr][nc] = new_cost
                q.append((new_cost, nr, nc, nd))
                
    return cache[-1][-1]
"""
[2020 카카오 인턴] 경주로 건설
해결: X
시간: 1H
"""