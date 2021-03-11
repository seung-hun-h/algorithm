from sys import stdin
readline = stdin.readline

def main():
    for _ in range(N):
        c, r, d, g = map(int, readline().split())
        make_dragon_curve(r, c, d, g)  
    print(count())

def count():
    ans = 0
    for r in range(100):
        for c in range(100):
            if _map[r][c] and _map[r+1][c] and _map[r][c+1] and _map[r+1][c+1]:
                ans += 1
    return ans

def make_dragon_curve(r, c , d, g):
    _dir = [d]

    for _ in range(g):
        temp = []
        for i in range(len(_dir)-1, -1, -1):
            temp.append((_dir[i] + 1) % 4)
        _dir += temp
    _map[r][c] = True
    for d in _dir:
        if d == 0:
            if c + 1 < 101:
                _map[r][c+1] = True
                c += 1
            else:
                break
        elif d == 1:
            if r - 1 >= 0:
                _map[r-1][c] = True
                r -= 1
            else:
                break
        elif d == 2:
            if c - 1 >= 0:
                _map[r][c-1] = True
                c -= 1
            else:
                break
        else:
            if r + 1 < 101:
                _map[r+1][c] = True
                r += 1
            else:
                break
if __name__ == "__main__":
    N = int(readline())
    _map = [[False] * 101 for _ in range(101)]
    main()