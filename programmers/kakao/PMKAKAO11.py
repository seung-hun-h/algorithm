def solution(m, n, board):
    answer = 0
    _board = [[board[r][c] for r in range(m-1, -1, -1)] for c in range(n)]
    while True:
        delete = [[False for _ in range(m)] for _ in range(n)]
        flag = False

        for r in range(n-1):
            for c in range(m-1):
                if _board[r][c] != "-":
                    if _board[r][c] == _board[r][c+1] == _board[r+1][c] == _board[r+1][c+1]:
                        if not delete[r][c]:
                            answer += 1
                            delete[r][c] = True
                        if not delete[r+1][c]:
                            answer += 1
                            delete[r+1][c] = True
                        if not delete[r+1][c+1]:
                            answer += 1
                            delete[r+1][c+1] = True
                        if not delete[r][c+1]:
                            answer += 1
                            delete[r][c+1] = True
                        flag = True
        if not flag:
            break

        temp = [[] for _ in range(n)]
        for r in range(n):
            for c in range(m):
                if not delete[r][c]:
                    temp[r].append(_board[r][c])

            while len(temp[r]) < m:
                temp[r].append("-")
        _board = temp
    return answer

board = ["CCBDE", "AAADE", "AAABF", "CCBBF"]
res = solution(len(board), len(board[0]), board)
print(res)