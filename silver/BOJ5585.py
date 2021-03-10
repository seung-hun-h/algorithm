from sys import stdin, setrecursionlimit

readline = stdin.readline

def main():
    cnt = 0
    rem = remain
    for coin in coins:
        if rem == 0: break
        cnt += (rem // coin)
        rem -= (coin * (rem // coin))
    
    print(cnt)
        
if __name__ == "__main__":
    remain = 1000 - int(readline().strip())
    coins = (500, 100, 50, 10, 5, 1)
    main()
