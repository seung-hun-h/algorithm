from sys import stdin, setrecursionlimit

readline = stdin.readline

def main():
    cnt = 0
    for num in arr:
        if is_prime(num):
            cnt += 1

    print(cnt)

def is_prime(num):
    if num == 2:
        return True
        
    if num == 1 or num % 2 == 0:
        return False

    flag = int(num ** 1/2) + 1
    for i in range(3, flag):
        if num % i == 0:
            return False

    return True
        
if __name__ == "__main__":
    N = int(readline().strip())
    arr = list(map(int, readline().split()))
    main()