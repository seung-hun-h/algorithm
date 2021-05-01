from collections import deque
def solution(board, moves):
    answer = 0
    _board = [deque() for _ in range(len(board))]
    result = deque()
    for c in range(len(board)):
        for r in range(len(board)):
            if board[r][c]:
                _board[c].appendleft(board[r][c])
    
    for move in moves:
        if _board[move-1]:
            cur = _board[move-1].pop()
            if result and result[-1] == cur:
                answer += 2
                result.pop()
            else:
                result.append(cur)

    return answer

solution([[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]], [1,5,3,5,1,2,1,4])