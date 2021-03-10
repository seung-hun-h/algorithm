from sys import stdin

readline = stdin.readline

result = []

def main():
    n = int(readline())

    A, B, C, D = [], [], [], []

    for i in range(n):
        line = [*map(int, readline().split())]
        A.append(line[0])
        B.append(line[1])
        C.append(line[2])
        D.append(line[3])

    AB = {}
    CD = {}

    for i in range(n):
        for j in range(n):
            AB[A[i] + B[j]] = AB.get(A[i] + B[j], 0) + 1
            CD[C[i] + D[j]] = CD.get(C[i] + D[j], 0) + 1
                
    ans = 0
    for key in AB.keys():
        ans += AB.get(key) * CD.get(-key, 0)
    print(ans)

if __name__ == "__main__":
    main()