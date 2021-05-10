def solution(n, k, cmd):
    front, rear, p = 0, n-1, k
    current = [True for i in range(n)]
    delete = []
    for command in cmd:
        c = command.split()
        if len(c) == 2:
            if c[0] == "U":
                cnt = 0
                for i in range(p-1, front-1, -1):
                    if current[i]:
                        cnt += 1
                        if cnt == int(c[1]):
                            p = i
                            break
            else:
                cnt = 0
                for i in range(p+1, rear+1):
                    if current[i]:
                        cnt += 1
                        if cnt == int(c[1]):
                            p = i
                            break

        else:
            # 삭제
            if c[0] == "C":
                delete.append(p)
                current[p] = False
                # 마지막 수 삭제한 경우
                if p == rear:
                    # 마지막 수 업데이트
                    for i in range(rear-1, front-1, -1):
                        if current[i]:
                            rear = i
                            break
                    p = rear

                elif p == front:
                    for i in range(front+1, rear+1):
                        if current[i]:
                            front = i
                            break
                    p = front
                else:
                    for i in range(p+1, n):
                        if current[i]:
                            p = i
                            break
            # 복구
            else:
                item = delete.pop()
                current[item] = True
                if item > rear:
                    rear = item
                elif item < front:
                    front = item

    return ''.join(['O' if current[i] else "X" for i in range(n)])

res = solution(8,	2,	["D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"])
print(res)