from sys import stdin, setrecursionlimit

readline = stdin.readline

def main():
    # 에라토스테네스의 체 알고리즘
    arr = [i for i in range(N+1)]
    arr[1] = 0 # 1은 소수가 아니다
    for i in range(2, N+1):
        if not arr[i]: continue
        for j in range(i+i, len(arr), i):
            arr[j] = 0

    for i in range(M, N+1):
        if not arr[i]: continue
        print(arr[i])
        
if __name__ == "__main__":
    M, N = map(int, readline().split())

    main()