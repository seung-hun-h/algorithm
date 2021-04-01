from sys import stdin

readline = stdin.readline



def get_point():
    for command in commands:
        visited = [False] * 4
        # 시계 방향 회전
        dfs(command[0]-1, command[1], visited)

    ans = 0 
    for i in range(4):
        if cycles[i][0] == 1:
            ans += 2 ** i

    print(ans)
 
def dfs(cycle, rot, visited):
    if cycle < 0 or cycle >= 4:
        return
    
    if not visited[cycle]:
        visited[cycle] = True
        if cycle - 1 >= 0 and cycles[cycle][6] != cycles[cycle-1][2]:
            dfs(cycle-1, rot * (-1), visited)
        if cycle + 1 < 4 and cycles[cycle][2] != cycles[cycle+1][6]:
            dfs(cycle+1, rot * (-1), visited)
        if rot == -1:
            cycles[cycle] = rotate_reverse(cycles[cycle])
        else:
            cycles[cycle] = rotate(cycles[cycle])

def rotate_reverse(cycle):
    temp = cycle[0]
    del cycle[0]
    cycle.append(temp)
    return cycle 

def rotate(cycle):
    temp = cycle.pop()
    cycle = [temp] + cycle
    return cycle

if __name__ == '__main__':
    cycles = [list(map(int, list(readline().strip()))) for _ in range(4)]
    commands = [list(map(int, readline().split())) for _ in range(int(readline()))]

    get_point()