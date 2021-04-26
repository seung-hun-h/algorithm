from sys import stdin
readline = stdin.readline

N = int(readline())
nums = [int(readline().strip()) for _ in range(N)]

def solve():
    stack = []
    oper = []
    seq = 1
    for num in nums:
        while not stack or seq <= num:
            stack.append(seq)
            seq += 1
            oper.append("+")

        if stack and stack[-1] == num:
            oper.append("-")
            stack.pop()
        else:
            print("NO")
            return

    for op in oper:
        print(op)
solve()