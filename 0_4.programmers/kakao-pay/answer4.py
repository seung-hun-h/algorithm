from collections import defaultdict
def solution(ages, wires):
    supply = defaultdict(int) # 최대 전력 가능 일

    for start, end, elec in wires:
        supply[end] = max(supply[end], ages[start-1]+elec)

    sorted_arr = sorted([[min(ages[node], supply[node+1]), node+1] for node in range(len(ages))], key=lambda x: [x[0], x[1]])
    print([node for _, node in sorted_arr])
    return [node for _, node in sorted_arr]
            

solution([35, 25, 3, 8, 7, 1], [[1, 2, 5], [2, 1, 5], [1, 3, 2], [3, 4, 2], [3, 5, 20], [4, 5, 1]])