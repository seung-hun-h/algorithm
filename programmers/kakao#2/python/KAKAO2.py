def solution(board, moves):
    answer = 0
    result = []
    
    for move in moves:
        for j in range(len(board)):
            if board[j][move - 1] == 0: continue
            
            if not result:
                result.append(board[j][move - 1])
                board[j][move - 1] = 0
                break
            
            if result[-1] == board[j][move - 1]:
                answer += 2
                result.pop()
            else:
                result.append(board[j][move - 1])
                
            board[j][move - 1] = 0
            break
    
    return answer

"""
[카카오 개발자 겨울 인턴] 크레인 인형 뽑기
해결: O
시간: 14분
"""