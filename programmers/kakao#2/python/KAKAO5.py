def solution(n, arr1, arr2):
    answer = []
    
    for num1, num2 in zip(arr1, arr2):
        current = bin(num1 | num2)[2:].zfill(n)
        answer.append(current.replace("1", "#").replace("0", " "))
    return answer

"""
[카카오 2018 공채] 비밀지도
해결: O
시간: 14분

문자열 관련 함수 잘 알아보기
"""