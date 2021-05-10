import heapq
def solution(n, k, cmd):
    # 이름을 정렬된 상태의 인덱스로 대신
    # left: max heap, right: min heap
    # left[0]: 현재 포인터, right[0]: 다음 포인터
    left, right, delete = [], [], []
    for i in range(n):
        if i <= k:
            heapq.heappush(left, -i)
        else:
            heapq.heappush(right, i)

    for command in cmd:
        com = command.split()
        if len(com) == 2:
            if com[0] == "U":
                for _ in range(int(com[1])):
                    heapq.heappush(right, -heapq.heappop(left))
            elif com[0] == "D":
                for _ in range(int(com[1])):
                    heapq.heappush(left, -heapq.heappop(right))

        else:
            # 삭제
            if com[0] == "C":
                # 삭제할 수가 없는 경우
                if not left and not right: continue
                # max heap에 수가 없는 경우
                if not left:
                    heapq.heappush(left, -heapq.heappop(right))
                delete.append(-heapq.heappop(left))
                if right:
                    heapq.heappush(left, -heapq.heappop(right))
            # 복구
            else:
                item = delete.pop()
                # 현재 포인터가 가르키는 숫자 보다 작은 경우
                # max heap에 삽입
                if left and item < -left[0]:
                    heapq.heappush(left, -item)
                # 그렇지 않을 경우
                # min heap에 삽입
                else:
                    heapq.heappush(right, item)

    answer = ['' for _ in range(n)]
    while left:
        answer[-left.pop()] = "O"
    while right:
        answer[right.pop()] = "O"
    while delete:
        answer[delete.pop()] = "X"

    return ''.join(answer)
res = solution(8,	2,	["D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"])
print(res)