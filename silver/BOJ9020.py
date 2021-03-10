from sys import stdin, setrecursionlimit

readline = stdin.readline

def main():
    for _ in range(N):
        num = int(readline().strip())
        f, s = get_gb_partition(num)
        print(f, s)

def get_gb_partition(num):
    prime = [True for _ in range(num+1)]
    prime[0] = prime[1] = False
    for i in range(2, int(num ** 0.5) + 1):
        if not prime[i]: continue
        for j in range(i+i, num+1, i):
            prime[j] = False

    # 중간에서 부터 양쪽으로 각각 진행
    # 가장 가까운 소수를 차례로 선택
    f = num // 2
    s = f

    while not (prime[f] and prime[s]):
        # 중간에서 시작했기 때문에
        # 같은 크기로 이동 해야 합이 num이 된다
        # ex) mid = num // 2
        #     mid * 2 == num
        #     (mid - 1) + (mid + 1) == num
        #     (mid - 1) + (mid + 2) != num 
        f -= 1
        s += 1

    return f, s

        
if __name__ == "__main__":
    N = int(readline().strip())
    main()