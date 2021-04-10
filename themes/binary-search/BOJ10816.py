from sys import stdin
readline = stdin.readline

M = int(readline())
nums = list(map(int, readline().split()))
N = int(readline())
cards = list(map(int, readline().split()))


def solve():
    num_count = dict()
    for num in nums:
        if num not in num_count.keys():
            num_count[num] = 0
        num_count[num] += 1
    
    for card in cards:
        if card not in num_count.keys():
            print(0, end=" ")
        else:
            print(num_count[card], end=" ")

def solve2():
    count = [0 for _ in range(20000001)]
    for num in nums:
        count[num+10000000] += 1
    
    for card in cards:
        print(count[card+10000000], end=" ")

solve2()