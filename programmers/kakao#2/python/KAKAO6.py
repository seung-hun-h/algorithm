def solution(dartResult):
    stack = []
    sdt = {"S": 1, "D": 2, "T": 3}
    for i in range(len(dartResult)):
        if not dartResult[i].isdigit():
            # 기호가 발견되면 인덱스 내려가며 숫자 찾기
            idx = i-1
            while idx >= 0 and dartResult[idx].isdigit():
                idx -= 1
            # 숫자 발견한 경우 스택에 추가
            if dartResult[idx+1:i].isdigit():
                stack.append(int(dartResult[idx+1:i]))

            if dartResult[i] in sdt:
                if stack:
                    stack[-1] = stack[-1] ** sdt[dartResult[i]]
            elif dartResult[i] == "*":
                if stack:
                    stack[-1] *= 2
                    if len(stack) >= 2:
                        stack[-2] *= 2
            elif dartResult[i] == "#":
                if stack:
                    stack[-1] *= -1
        
    return sum(stack)


"""
[카카오 2018 공채] 다트 게임
해결: O
시간: 22분
"""