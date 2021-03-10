from sys import stdin

readline = stdin.readline

def main():
    stack = []
    for ch in line:
        stack.append(ch)

    cnt = 0
    while stack:
        cur = stack.pop()
        if not stack: 
            cnt += 1
            break

        if cur == '=':
            cur = stack.pop()
            if cur == 'z' and stack and stack[-1] == 'd':
                stack.pop()    
        elif cur == '-':
            stack.pop()
        elif cur == 'j':
            if stack and stack[-1] == 'n' or stack[-1] == 'l':
                stack.pop()

        cnt += 1

    print(cnt)


if __name__ == "__main__":
    line = readline().strip()
    main()