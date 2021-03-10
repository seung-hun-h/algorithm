from sys import stdin, setrecursionlimit

readline = stdin.readline

def main():
    # 유클리드 호제법
    A, B = map(int, readline().split())
    _min, _max = min(A, B), max(A, B)

    while _min != 0:
        temp = _min
        _min = _max % _min
        _max = temp

    print(''.join([str(1) for _ in range(_max)]))
        
        
if __name__ == "__main__":
    main()