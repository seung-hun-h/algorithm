import heapq

def solution(n, k, cmds):
    left, right, removed = [-i for i in range(k + 1)], [i for i in range(k+1, n)], []
    
    heapq.heapify(left)
    heapq.heapify(right)
    
    for cmd in cmds:
        if cmd[0] == "U":
            cnt = int(cmd.split(" ")[1])
            
            for _ in range(cnt):
                heapq.heappush(right, -heapq.heappop(left))
                
        elif cmd[0] == "D":
            cnt = int(cmd.split(" ")[1])
            
            for _ in range(cnt):
                heapq.heappush(left, -heapq.heappop(right))
                
        elif cmd[0] == "C":
            removed.append(-heapq.heappop(left))
            
            if right:
                heapq.heappush(left, -heapq.heappop(right))
        else:
            num = removed.pop()
            if num > -left[0]:
                heapq.heappush(right, num)
            else:
                heapq.heappush(left, -num)
                
    answer = ["O" for _ in range(n)]
    while removed:
        answer[removed.pop()] = "X"
    return "".join(answer)

'''
[카카오 2021 인턴] 표 편집
해결: O
'''