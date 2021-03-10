from sys import stdin

readline = stdin.readline


upper = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
lower = 'abcdefghijklmnopqrstuvwxyz'
digit = '0123456789'

upper_s = 65
digit_s = 48
lower_s = 97

def main():
    if char.isdigit():
        print(digit_s + digit.index(char))
    elif char.isupper():
        print(upper_s + upper.index(char))
    else:
        print(lower_s + lower.index(char))

if __name__ == "__main__":
    char = readline().strip()   
    main()