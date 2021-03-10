from sys import stdin
readline = stdin.readline

def main():
    print(' '.join(list(map(str, sorted(arr)))))
    
if __name__ == "__main__":
    N = int(readline().strip())
    arr = [*map(int, readline().split())]
   
    main()