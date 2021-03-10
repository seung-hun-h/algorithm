from sys import stdin
readline = stdin.readline

def count_gm(num):
    global cnt
    if num > B:
        return
    if A <= num:
        cnt += 1

    count_gm(num * 10 + 4)
    count_gm(num * 10 + 7)


if __name__ == "__main__":
    A, B = map(int, readline().split())
    cnt = 0
    count_gm(4)
    count_gm(7)

    print(cnt)