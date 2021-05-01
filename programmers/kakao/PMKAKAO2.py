from itertools import permutations # 알고리즘 풀이의 효율성을 위해사용
def solution(expression):
    answer = 0
    numbers = []
    operators = []
    last_op = -1
    for i in range(len(expression)):
        if not expression[i].isdigit():
            numbers.append(int(expression[last_op+1:i]))
            operators.append(expression[i])
            last_op = i
    numbers.append(int(expression[last_op+1:]))

    operator = ["*", "+", "-"]
    for priority in permutations(operator, 3):
        temp_numbers = numbers[:]
        temp_ops = operators[:]
        for p in priority:
            i = 0
            while i < len(temp_ops):
                if temp_ops[i] == p:
                    num1 = temp_numbers[i]
                    num2 = temp_numbers.pop(i+1)

                    temp_numbers[i] = calc(num1, num2, temp_ops.pop(i))
                    i -= 1
                i+=1
        answer = max(answer, abs(temp_numbers[0]))
    return answer

def calc(a, b, p):
    if p == "+":
        return a + b
    elif p == "-":
        return a - b
    else:
        return a * b
