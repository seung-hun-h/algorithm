from sys import stdin
readline = stdin.readline

def count_piece(line):
    idx = 0
    cnt = 0
    stack = []
    while idx < len(line):
        cur = line[idx]
        # 여는 괄호인 경우
        if cur == '(':
            # 다음 괄호가 닫는 괄호이면 레이저
            if line[idx+1] == ')':
                # 다음 인덱스로 넘어감
                idx += 1
                # 조각 카운팅
                cnt += len(stack)
            else:
                stack.append('(')
        # 레이저가 아닌 쇠 끝인 경우
        # stack에서 여는 괄호 제거하고 조각 카운팅
        if cur == ')':
            stack.pop()
            cnt += 1
        idx += 1
    
    return cnt


if __name__ == "__main__":
    line = readline().strip()
    print(count_piece(line))