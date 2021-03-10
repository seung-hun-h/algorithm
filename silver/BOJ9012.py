from sys import stdin
readline = stdin.readline

def is_VPS(ps):
    stack = []
    for i in range(len(ps)):
        cur = ps[i]
        # 여는 괄호일 경우 stack에 저장
        if cur == '(':
            stack.append(cur)
        # 닫는 괄호일 경우 stack 내부 여는 괄호 꺼내기
        # 단, stack이 비어있을 경우 VPS 아님
        elif cur == ')':
            if not stack:
                return False
            stack.pop()

    # VPS일 경우 괄호의 짝이 모두 맞기 때문에
    # stack에 괄호가 존재할 경우 VPS 아님 
    if stack:
        return False
        
    return True
    

if __name__ == "__main__":
    N = int(readline().strip())

    for _ in range(N):
        if is_VPS(readline().strip()):
            print('YES')
        else:
            print('NO')