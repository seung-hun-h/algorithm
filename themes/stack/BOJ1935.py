from sys import stdin
readline = stdin.readline

N = int(readline().strip())
post = readline().strip()
arr = [int(readline().strip()) for _ in range(N)]

def solve():
    results = []
    for i in range(len(post)):
        if post[i].isalpha():
            results.append(arr[ord(post[i]) - ord('A')])
        else:
            n1 = results.pop()
            n2 = results.pop()
            if post[i] == "*":
                result = n1 * n2
            elif post[i] == "+":
                result = n1 + n2
            elif post[i] == "-":
                result = n2 - n1
            else:
                result = n2 / n1
            results.append(result)

    print('%.2f' % results[0])

solve()