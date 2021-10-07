from sys import stdin
readline = stdin.readline

G = int(readline().strip())

def solve():

    left, right, result = 1, 1, []

    while right ** 2 - (right - 1) ** 2 <= G:
        diff = right ** 2 - left ** 2

        if diff == G:
            result.append(right)
            right += 1

        elif diff > G:
            left += 1
        
        else:
            right += 1

    if not result:
        print(-1)
    else:
        for num in result:
            print(num)

solve()

