from sys import stdin  
readline = stdin.readline

_min = 10000000000
_max = 0

def solve():
    num = readline().strip()
    divide(num, 0)
    print(_min, _max)

def divide(num, count):
    global _max, _min
    count += count_odds(num)

    if len(num) <= 1:
        _min = min(_min, count)
        _max = max(_max, count)
        return

    if len(num) == 2:
        result = str(sum(map(int, [num[0], num[1]])))
        divide(result, count)
        return

    for left in range(1, len(num) - 1):
        for right in range(left + 1, len(num)):
            result = str(sum(map(int, [num[:left], num[left:right], num[right:]])))
            divide(result, count)

            
def count_odds(num):
    return sum(int(n) % 2 for n in num)


solve()