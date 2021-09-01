from sys import stdin
readline = stdin.readline

N = int(readline())
cranes = list(map(int, readline().split()))
M = int(readline())
boxes = list(map(int, readline().split()))

def solve():
    time = 0
    cranes.sort(reverse=True)
    boxes.sort(reverse=True)
    if boxes[0] > cranes[0]:
        print(-1)
        return

    moved = set()
    while moved < M:
        time += 1
        for crane in cranes:
            if moved == M: break
            for i, box in enumerate(boxes):
                if box <= crane and i not in moved:
                    moved.add(i)
                    break
    
    print(time)

def solve2():
    import heapq
    cranes.sort()
    boxes.sort()

    works_per_crane = []

    for i in reversed(range(M)):
        # 현재 박스를 옮길 수 있는 크레인 
        while cranes and cranes[-1] >= boxes[i]:
            cranes.pop()
            heapq.heappush(works_per_crane, 0)
        # 일할 수 있는 크레인이 없는 경우 종료
        if not works_per_crane: break

        # 할당 가능한 크레인 중 가장 적게 일한 크레인에게 작업 할당
        work_counts = heapq.heappop(works_per_crane)
        heapq.heappush(works_per_crane, work_counts+1)


    print(heapq.nlargest(1, works_per_crane)[0] if works_per_crane else -1)
solve()
"""
해결: X
시간: 50분

오름차순으로 정렬하면 안되는 이유:
오름차순으로 정렬하면, 나중에 박스의 무게가 무거워져 무게 제한이 낮은 크레인이 일을 하지 않는다.
내림차순으로 정렬할 경우, 미리 무게 제한이 높은 크레인에게 박스를 할당하여 좀 더 효율적이다.
"""