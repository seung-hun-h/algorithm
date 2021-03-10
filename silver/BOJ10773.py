from sys import stdin

readline = stdin.readline


def get_correct_sum():
    cur = 0
    # 가장 최근에 0이 아닌수 저장
    stack = []
    for _ in range(K):
        cur = int(readline().strip())

        if cur == 0:
            stack.pop()
        else:
            stack.append(cur)

    return sum(stack)

if __name__ == "__main__":
    K = int(readline().strip())

    print(get_correct_sum())