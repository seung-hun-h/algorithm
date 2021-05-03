
def solution(msg):
    answer = []
    # initial
    _dict = {}
    for i, char in enumerate([chr(ord("A")+i) for i in range(26)]):
        _dict[char] = i+1
    last = 27
    start = 0 # 사전 검색 시작 포인터
    while start < len(msg):
        i = start
        # j: 늘려나갈 단어 사이즈
        for j in range(i+1, len(msg) + 1):
            cur = msg[i:j]
            if cur not in _dict:
                start = j-1
                answer.append(_dict[msg[i:j-1]])
                _dict[cur] = last
                last += 1
                break

        # msg[i:]가 이미 사전에 존재함
        # 번호 저장후 종료
        if start == i:
            answer.append(_dict[msg[i:]])
            break

    return answer


msg = "KAKAO"
res = solution(msg)
print(res)