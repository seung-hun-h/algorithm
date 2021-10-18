from sys import stdin  
readline = stdin.readline

A, B = readline().split()

def solve():
    ans = []

    for i in range(2, 37):
        a = conversion_to_ten(A, i)
        if a == -1:
            continue

        for j in range(2, 37):

            b = conversion_to_ten(B, j)

            if b == -1 or i == j:
                continue

            if a == b:
                if not ans:
                    ans = [a, i, j]
                else:
                    print("Multiple")
                    return
    
    if not ans:
        print("Impossible")
    else:
        print(*ans)

def conversion_to_ten(num, N):
    result = 0

    for i, n in enumerate(num[::-1]):
        if str.isdigit(n):
            current = int(n)
        else:
            current = (10 + ord(n) - ord('a'))

        if current >= N:
            return -1
        
        result += current * N**i

    if result >= 2**63:
        return -1

    return result

solve()