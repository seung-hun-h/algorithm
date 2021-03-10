from sys import stdin
readline = stdin.readline

def main():
    _next = 0
    _prev = 0
    for i in range(len(arr)):
        if arr[i] > n:
            _next = arr[i]
            if i > 0:
                _prev = arr[i-1]
            break
    
    cnt = 0
    for start in range(_prev+1, n+1):
        for end in range(n, _next):
            if start != end:
                cnt += 1
    
    print(cnt)

if __name__ == "__main__":
    L = int(readline().strip())
    arr = sorted([*map(int, readline().split())])
    n = int(readline().strip())
    main()