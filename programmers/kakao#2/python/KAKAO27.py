from collections import deque

_board = [[]]
INF = float('inf')
D = [[1, 0], [-1, 0], [0, 1], [0, -1]]

def solution(board, r, c):
    global _board
    _board = board
    src = (r, c, 0)
    return permutate(src)

def permutate(src):
    result = INF
    for num in range(1, 7):
        pair = []
        for r in range(4):
            for c in range(4):
                if (_board[r][c] == num):
                    pair.append((r, c, 0))
                    
        if not pair:
            continue
        
        one = bfs(src, pair[0]) + bfs(pair[0], pair[1]) + 2
        two = bfs(src, pair[1]) + bfs(pair[1], pair[0]) + 2
        
        for i in range(2):
            _board[pair[i][0]][pair[i][1]] = 0
        
        result = min(result, one + permutate(pair[1]))
        result = min(result, two + permutate(pair[0]))
            
        for i in range(2):
            _board[pair[i][0]][pair[i][1]] = num
    
    return result if result != INF else 0

def bfs(start, end):
    visited = [[False for _ in range(4)] for _ in range(4)] 
    q = deque()
    
    visited[start[0]][start[1]] = True
    q.append(start)
    
    while q:
        row, col, cnt = q.popleft();
        
        if (row == end[0] and col == end[1]):
            return cnt
        
        for i in range(4):
            nr, nc = row + D[i][0], col + D[i][1]
            
            if nr < 0 or nr > 3 or nc < 0 or nc > 3: continue
            
            if not visited[nr][nc]:
                visited[nr][nc] = True
                q.append((nr, nc, cnt + 1))
            
            for _ in range(2):
                if _board[nr][nc]: break
                if nr + D[i][0] < 0 or nr + D[i][0] > 3 or nc + D[i][1] < 0 or nc + D[i][1] > 3:
                    break
                
                nr += D[i][0]
                nc += D[i][1]
            
            if not visited[nr][nc]:
                visited[nr][nc] = True
                q.append((nr, nc, cnt + 1))
    return INF
'''
[카카오 2021 공채] 카드 짝 맞추기
해결: X
'''