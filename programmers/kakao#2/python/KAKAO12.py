from itertools import permutations

def solution(expression):
    answer = 0    
    for priority in permutations("*+-", 3):
        answer = max(answer, get_result(priority, expression))
    return answer

def get_result(priority, expression):
    nums = []
    opers = []
    
    prev = -1
    for i, char in enumerate(expression):
        if not char.isdigit():
            nums.append(int(expression[prev+1:i]))
            prev = i
            
            while opers and is_smaller_priority(priority, expression[i], opers[-1]):
                nums.append(operate(nums.pop(), nums.pop(), opers.pop()))
                
            opers.append(expression[i])
                
    nums.append(int(expression[prev+1:]))
    while opers:
        nums.append(operate(nums.pop(), nums.pop(), opers.pop()))
    
    return abs(nums[-1])

def is_smaller_priority(priority, oper1, oper2):
    return priority.index(oper1) <= priority.index(oper2)

def operate(num1, num2, oper):
    return eval(str(num2)+oper+str(num1))

"""
[카카오 2020 인턴] 수식 최대화
해결: O
시간: 57분
다시 풀 필요 있다.
"""