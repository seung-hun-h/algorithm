from sys import stdin
from copy import deepcopy
readline = stdin.readline

cube = [[[0, 0, 0], [0, 0, 0], [0, 0, 0]],
        [[1, 1, 1], [1, 1, 1], [1, 1, 1]],
        [[2, 2, 2], [2, 2, 2], [2, 2, 2]],
        [[3, 3, 3], [3, 3, 3], [3, 3, 3]],
        [[4, 4, 4], [4, 4, 4], [4, 4, 4]],
        [[5, 5, 5], [5, 5, 5], [5, 5, 5]]]
T = int(readline().strip())

def solve():
    for _ in range(T):
        cur = deepcopy(cube)
        n = int(readline().strip())
        commands = readline().split()
        for command in commands:
            com = list(command)
            
            if com[0] == "L":
                rotate_left_side(com[1], cur)
            elif com[0] == "R":
                rotate_right_side(com[1], cur)
            elif com[0] == "U":
                rotate_up_side(com[1], cur)
            elif com[0] == "D":
                rotate_down_side(com[1], cur)
            elif com[0] == "F":
                rotate_front_side(com[1], cur)
            else:
                rotate_back_side(com[1], cur)

        for side in cur[0]:
            for i in range(2, -1, -1):
                value = side[i]
                if value == 0:
                    print("w", end="")
                elif value == 1:
                    print("y", end="")
                elif value == 2:
                    print("r", end="")
                elif value == 3:
                    print("o", end="")
                elif value == 4:
                    print("g", end="")
                elif value == 5:
                    print("b", end="")
            print()

    
def rotate_left_side(_dir, cur):
    if _dir == "+":
        temp = [cur[0][0][2], cur[0][1][2], cur[0][2][2]]

        for i in range(3):
            cur[0][i][2] = cur[3][2-i][0]
            
        for i in range(3):
            cur[3][i][0] = cur[1][i][0]

        for i in range(3):
            cur[1][i][0] = cur[2][i][0]

        for i in range(3):
            cur[2][i][0] = temp[2-i]

    else:
        temp = [cur[0][0][2], cur[0][1][2], cur[0][2][2]]

        for i in range(3):
            cur[0][i][2] = cur[2][2-i][0]
            
        for i in range(3):
            cur[2][i][0] = cur[1][i][0]

        for i in range(3):
            cur[1][i][0] = cur[3][i][0]

        for i in range(3):
            cur[3][i][0] = temp[2-i]
    rotate_side(_dir, cur[4])

def rotate_right_side(_dir, cur):
    if _dir == "-":
        temp = [cur[0][0][0], cur[0][1][0], cur[0][2][0]]

        for i in range(3):
            cur[0][i][0] = cur[3][2-i][2]
            
        for i in range(3):
            cur[3][i][2] = cur[1][i][2]

        for i in range(3):
            cur[1][i][2] = cur[2][i][2]

        for i in range(3):
            cur[2][i][2] = temp[2-i]

    else:
        temp = [cur[0][0][0], cur[0][1][0], cur[0][2][0]]

        for i in range(3):
            cur[0][i][0] = cur[2][2-i][2]
            
        for i in range(3):
            cur[2][i][2] = cur[1][i][2]

        for i in range(3):
            cur[1][i][2] = cur[3][i][2]

        for i in range(3):
            cur[3][i][2] = temp[2-i]
    rotate_side(_dir, cur[5])

def rotate_front_side(_dir, cur):
    if _dir == "+":
        temp = [cur[0][2][0], cur[0][2][1], cur[0][2][2]]

        for i in range(3):
            cur[0][2][i] = cur[4][2][i]
            
        for i in range(3):
            cur[4][2][i] = cur[1][2][i]

        for i in range(3):
            cur[1][2][i] = cur[5][2][i]

        for i in range(3):
            cur[5][2][i] = temp[i]

    else:
        temp = [cur[0][2][0], cur[0][2][1], cur[0][2][2]]

        for i in range(3):
            cur[0][2][i] = cur[5][2][i]
            
        for i in range(3):
            cur[5][2][i] = cur[1][2][i]

        for i in range(3):
            cur[1][2][i] = cur[4][2][i]

        for i in range(3):
            cur[4][2][i] = temp[i]

    rotate_side(_dir, cur[2])

def rotate_back_side(_dir, cur):
    if _dir == "-":
        temp = [cur[0][0][0], cur[0][0][1], cur[0][0][2]]

        for i in range(3):
            cur[0][0][i] = cur[4][0][i]
            
        for i in range(3):
            cur[4][0][i] = cur[1][0][i]

        for i in range(3):
            cur[1][0][i] = cur[5][0][i]

        for i in range(3):
            cur[5][0][i] = temp[i]

    else:
        temp = [cur[0][0][0], cur[0][0][1], cur[0][0][2]]

        for i in range(3):
            cur[0][0][i] = cur[5][0][i]
            
        for i in range(3):
            cur[5][0][i] = cur[1][0][i]

        for i in range(3):
            cur[1][0][i] = cur[4][0][i]

        for i in range(3):
            cur[4][0][i] = temp[i]

    rotate_side(_dir, cur[3])

def rotate_up_side(_dir, cur):
    if _dir == "+":
        temp = [cur[4][0][0], cur[4][1][0], cur[4][2][0]]

        for i in range(3):
            cur[4][i][0] = cur[2][2][i]
            
        for i in range(3):
            cur[2][2][i] = cur[5][2-i][2]

        for i in range(3):
            cur[5][i][2] = cur[3][0][i]

        for i in range(3):
            cur[3][0][i] = temp[2-i]

    else:
        temp = [cur[4][0][0], cur[4][1][0], cur[4][2][0]]

        for i in range(3):
            cur[4][i][0] = cur[3][0][2-i]
            
        for i in range(3):
            cur[3][0][i] = cur[5][i][2]

        for i in range(3):
            cur[5][i][2] = cur[2][2][2-i]

        for i in range(3):
            cur[2][2][i] = temp[i]

    rotate_side(_dir, cur[0])

def rotate_down_side(_dir, cur):
    if _dir == "-":
        temp = [cur[4][0][2], cur[4][1][2], cur[4][2][2]]

        for i in range(3):
            cur[4][i][2] = cur[2][0][i]
            
        for i in range(3):
            cur[2][0][i] = cur[5][2-i][0]

        for i in range(3):
            cur[5][i][0] = cur[3][2][i]

        for i in range(3):
            cur[3][2][i] = temp[2-i]

    else:
        temp = [cur[4][0][2], cur[4][1][2], cur[4][2][2]]

        for i in range(3):
            cur[4][i][2] = cur[3][2][2-i]
            
        for i in range(3):
            cur[3][2][i] = cur[5][i][0]

        for i in range(3):
            cur[5][i][0] = cur[2][0][2-i]

        for i in range(3):
            cur[2][0][i] = temp[i]

    rotate_side(_dir, cur[1])

def rotate_side(_dir, side):
    temp = deepcopy(side)
    if _dir == "-":
        for i in range(3):
            side[i][0] = temp[2][i]
            side[i][1] = temp[1][i]
            side[i][2] = temp[0][i]
    else:
       for i in range(3):
            side[i][0] = temp[0][2-i]
            side[i][1] = temp[1][2-i]
            side[i][2] = temp[2][2-i]

solve()
