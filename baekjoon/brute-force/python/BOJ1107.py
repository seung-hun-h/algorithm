from sys import stdin
from collections import defaultdict

readline = stdin.readline

INF = 1000000
N = int(readline())
M = int(readline())
out_of_control = set()

for num in list(map(int, readline().split())):
    out_of_control.add(num)

def solve():
    result = abs(N - 100)

    min_diff_num = get_min_diff_num()

    result = min(result, abs(min_diff_num - N) + len(str(min_diff_num)))
    print(result)

def get_min_diff_num():
    min_diff = INF
    num = INF
    for i in range(INF):
        diff = abs(i - N)
        if check(i) and diff < min_diff:
            min_diff = diff
            num = i

    return num

def check(num):
    if num == 0:
        return num not in out_of_control

    temp = num

    while temp != 0:
        remain = temp % 10

        if remain in out_of_control:
            return False

        temp //= 10

    return True

solve()