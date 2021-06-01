def solution(left, right):
    answer = 0
    for num in range(left, right+1):
        if check(num):
            print(num)
            answer += num
        else:
            answer -= num
    return answer

def check(num):
    cnt = 2
    for i in range(2, num//2+1):
        if num % i == 0:
            cnt += 1
    
    return cnt % 2 == 0

solution(13, 17)