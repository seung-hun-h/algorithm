from sys import stdin
readline = stdin.readline

bits = {
    0: int(0b0111111),
    1: int(0b0001100),
    2: int(0b1011011),
    3: int(0b1011110),
    4: int(0b1101100),
    5: int(0b1110110),
    6: int(0b1110111),
    7: int(0b0011100),
    8: int(0b1111111),
    9: int(0b1111110)
}

N, K, P, X = map(int, readline().split())
diff_table = [[0 for _ in range(10)] for _ in range(10)]

def solve():
    ans = 0

    build_diff_table()

    for num in range(1, N + 1):
        if reversible(num):
            ans += 1

    print(ans)

def build_diff_table():
    for i in range(9):
        for j in range(i + 1, 10):
            count = count_diff(i, j)
            diff_table[i][j] = count
            diff_table[j][i] = count

def reversible(num):
    origin = X
    count = 0

    for _ in range(K):
        count += diff_table[origin % 10][num % 10]
        origin, num = origin // 10, num // 10

    return 1 <= count <= P

def count_diff(num1, num2):
    return bin(bits[num1] ^ bits[num2])[2:].count('1')


solve()