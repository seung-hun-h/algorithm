from sys import stdin

readline = stdin.readline

def get_fibo():
    if N == 0 or N == 1:
        return N

    prev = 0
    cur = 1
    _next = prev + cur
    for i in range(2, N+1):
        _next = (prev + cur) % 1000000
        if _next == 0:
            print(i, prev, cur)
        prev = cur % 1000000
        cur = _next % 1000000
    
    return _next % 1000000

def get_fibo_matrix():
    global N
    ans = [[1, 0], [0, 1]]
    mat = [[1, 1], [1, 0]]

    while N > 0:
        if N % 2 == 1:
            ans = mat_multiply(ans, mat)
        mat = mat_multiply(mat, mat)
        N //= 2
    
    print(ans[0][1] % 1000000)

def mat_multiply(m1, m2):
    result = [[0, 0], [0, 0]]
    for i in range(len(m1)):
        for j in range(len(m1)):
            for k in range(len(m1)):
                result[i][j] += (m1[i][k] * m2[k][j]) % 1000000
    
    return result

    

if __name__ == "__main__":
    N = int(readline())
    # N %= 1500000
    # print(get_fibo())
    get_fibo_matrix()