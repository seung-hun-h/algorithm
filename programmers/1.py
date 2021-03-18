def solution(paper, n):
    answer = dfs(paper, n, len(paper), max(paper))
    return answer

def dfs(paper, n, length, _max):
    if n == 0:
        return _max

    for f in range(length):
        
        left = paper[:f]
        right = paper[f:]
        print(left, right, end=" ")
        limit_len = min(len(left), len(right))
        temp = [0] * limit_len

        for i in range(limit_len):
                temp[i] = right[i] + left[-(i+1)]
                _max = max(_max, temp[i])

        # 오른쪽 방향으로 접기
        if len(left) < len(right):
            _max = dfs(temp+right[limit_len:], n-1, len(temp+right[limit_len:]), _max)
        else:
        # 왼쪽 방향으로 접기
            temp.reverse()   
            _max = dfs(left[:-limit_len]+temp, n-1, len(temp+left[:-limit_len]), _max)
    return _max

print(solution([7, 3, 5, -2, 9], 2))