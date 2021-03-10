from sys import stdin
from collections import deque

readline = stdin.readline

def is_balanced(line):
    # 여는 괄호가 나타날경우 스택에 저장
    stack = []

    # 두 괄호 중 닫는 괄호가 나오는 경우
    # 가장 최근에 나타난 여는 괄호와 짝이 맞아야 균형잡힌것
    # 가장 최근에 나타난 여는 괄호는 stack.pop()
    
    for i in range(len(line)):
        cur = line[i]
        if cur == "(" or cur == "[":
            stack.append(cur)
        elif cur == ")":
            if not stack or stack.pop() != "(":
                return False
            
        elif cur == "]":
            if not stack or stack.pop() != "[":
                return False

    if stack:
        return False
 
    return True
        
if __name__ == "__main__":
    line = readline()

    while line != ".\n":
        if is_balanced(line):
            print('yes')
        else:
            print('no')
        
        line = readline()
