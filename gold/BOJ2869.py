from sys import stdin
import math

readline = stdin.readline

def main():
    A, B, V = map(int, readline().split())
    # 0: 낮, 1: 밤
    n = math.ceil((V-A) / (A-B)) + 1
    print(n)

if __name__ == '__main__':
    main()