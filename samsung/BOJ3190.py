from sys import stdin
from collections import deque
readline = stdin.readline

# right: 0, down: 1, left: 2, up: 3
# D: (dir+1) % 4, L: ((dir-1)+4)%4
def main():
    _dir = 0
    sec = 0
    snake = [[0, 0]]
    change_dir = deque()
    while 0 <= snake[0][0] < N and 0 <= snake[0][1] < N:
        sec += 1
        head = [snake[0][0], snake[0][1]]
        if _dir == 0:
            # Right 이동
            head[1] += 1
            if head[1] >= N or head in snake:
                return sec 

            # 사과를 먹었을 경우
            if _map[head[0]][head[1]] == 1:
                _map[head[0]][head[1]] = 0
            else:
            # 사과를 먹지 않았을 경우 >> tail to head >> snake.pop() 
                snake.pop()
            snake = [head] + snake 
            
            # 방향 전환인 경우
            if direcs and direcs[0][0] == sec:
                for _ in range(len(snake)-1):
                    change_dir.append([0, 1])
                if direcs[0][1] == "D":
                    _dir = (_dir+1) % 4
                else:
                    _dir = ((_dir-1)+4)% 4
                
                del direcs[0]

        elif _dir == 1:
             # Down 이동
            head[0] += 1
            if head[0] >= N or head in snake:
                return sec

            # 사과를 먹었을 경우
            if _map[head[0]][head[1]] == 1:
                _map[head[0]][head[1]] = 0
            else:
                snake.pop()
            snake = [head] + snake

            # 방향 전환인 경우
            if direcs and direcs[0][0] == sec:
                for _ in range(len(snake)-1):
                    change_dir.append([1, 0])
                if direcs[0][1] == "D":
                    _dir = (_dir+1) % 4
                else:
                    _dir = ((_dir-1)+4)% 4
                
                del direcs[0]

        elif _dir == 2 :
            # left 이동
            head[1] -= 1
            if head[1] < 0 or head in snake:
                return sec

            # 사과를 먹었을 경우
            if _map[head[0]][head[1]] == 1:
                _map[head[0]][head[1]] = 0
            else:
                snake.pop()

            snake = [head] + snake

            # 방향 전환인 경우
            if direcs and direcs[0][0] == sec:
                for _ in range(len(snake)-1):
                    change_dir.append([0, -1])
                if direcs[0][1] == "D":
                    _dir = (_dir+1) % 4
                else:
                    _dir = ((_dir-1)+4)% 4
                
                del direcs[0]
        else:
            # up 이동
            head[0] -= 1
            if head[0] < 0 or head in snake:
                return sec

            # 사과를 먹었을 경우
            if _map[head[0]][head[1]] == 1:
                _map[head[0]][head[1]] = 0
            else:
                snake.pop()
            snake = [head] + snake

             # 방향 전환인 경우
            if direcs and direcs[0][0] == sec:
                for _ in range(len(snake)-1):
                    change_dir.append([-1, 0])
                if direcs[0][1] == "D":
                    _dir = (_dir+1) % 4
                else:
                    _dir = ((_dir-1)+4)% 4
                
                del direcs[0]

    return sec


if __name__ == "__main__":
    N = int(readline())
    _map = [[0] * N for _ in range(N)]
    for _ in range(int(readline())):
        r, c = map(int, readline().split())
        _map[r-1][c-1] = 1

    direcs = []
    for _ in range(int(readline())):
        line = readline().split()
        direcs.append([int(line[0]), line[1]])
    print(main())
