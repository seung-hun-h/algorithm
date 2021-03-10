from sys import stdin

readline = stdin.readline

def main():
    qou = num // 14
    rem = num % 14

    if rem == 3 or rem == 7 or rem == 11:
        if qou > 2:
            print('tu+ru*{}'.format(qou+2))
        else:
            print(words[rem] + ('ru'*qou))
    elif rem == 4 or rem == 8 or rem == 12:
        if qou > 3:
            print('tu+ru*{}'.format(qou+1))
        else:
            print(words[rem] + ('ru'*qou))
    else:
        print(words[rem])

        
if __name__ == "__main__":
    num = int(readline().strip())
    words = ['sukhwan', 'baby', 'sukhwan', 'tururu', 'turu', 'very', 'cute',
                'tururu', 'turu', 'in', 'bed', 'tururu', 'turu',
                    'baby']
    main()