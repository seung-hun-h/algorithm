from sys import stdin

readline = stdin.readline

def main():
    arr = sorted(list(map(int, readline().split())))
    offset = ord('A')
    idx = [ord(char) - offset for char in readline().strip()]
    
    string = ''
    for i in idx:
        string += str(arr[i]) + " "

    print(string)


if __name__ == "__main__":
    main()