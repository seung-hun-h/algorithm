from sys import stdin, maxsize

readline = stdin.readline

def main():
    if N == 1:
        dice.sort()
        value = 0
        for i in range(0, len(dice)-1):
            value += dice[i]
        print(value)
        return
        
    op_list = []
    op_list.append(min(dice[0], dice[5]))
    op_list.append(min(dice[1], dice[4]))
    op_list.append(min(dice[2], dice[3]))

    op_list.sort()

    value = op_list[0] * (5 * (N ** 2) - 8 * N + 4)
    value += op_list[1] * (8 * (N - 1))
    value += op_list[2] * 4

    print(value)

if __name__ == "__main__":
    N = int(readline().strip())
    dice = list(map(int, readline().split()))
    main()