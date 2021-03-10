from sys import stdin

readline = stdin.readline

def main():
    for i in range(1, num+1):
        if i % 2 == 0:
            star = ' '
            for j in range(num):
                star += "* "
        else:
            star = ''
            for j in range(num):
                star += "* "
        print(star)

if __name__ == "__main__":
    num = int(readline().strip())
    main()