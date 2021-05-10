import heapq
def solution(t, r):
    answer = []
    _dict = dict()
    for idx, time in enumerate(t):
        _dict[idx] = time
    q = []
    # 0 - 10000 시간까지
    for time in range(10001):
        delete = []
        for key in _dict:
            if _dict[key] == time:
                # 우선순위: 1. 등급 2. 도착시간 3. 아이디 크기
                heapq.heappush(q, [r[key], time, key])
                delete.append(key)

        # 탑승 시간 지난 인원 삭제
        while delete:
            del _dict[delete.pop()]
        # 탑승
        if q:
            answer.append(heapq.heappop(q)[2])
        if not _dict:
            break
    # 나머지 
    while q:
        answer.append(heapq.heappop(q)[2])

    
    return answer

res = solution([7,6,8,1],	[0,1,2,3])
print(res)