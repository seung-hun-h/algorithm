from sys import stdin, setrecursionlimit

readline = stdin.readline

def main():
    li_numbers = sorted(list(map(int, numbers)), reverse=True)
    num = int(''.join(list(map(str, li_numbers))))
    print(num if sum(li_numbers) % 3 == 0 and num % 30 == 0 else -1)
if __name__ == "__main__":
    numbers = readline().strip()
    main()
