from sys import stdin
import heapq

readline = stdin.readline

def main():
    T, W = map(int, readline().split())
    seq = [int(readline()) for _ in range(T)]
    d = [0 for _ in range(W+1)]

    for i in range(T):
        place = seq[i]
        for j in range(W+1):
            if place == 1:
                if j == 0:
                    d[j] += 1
                elif j % 2 == 0:
                    d[j] = max(d[j]+1, d[j-1] + 1)
            else:
                if j % 2 == 1:
                    d[j] = max(d[j]+1, d[j-1] + 1)
    print(max(d))
 
if __name__ == "__main__":
    main()