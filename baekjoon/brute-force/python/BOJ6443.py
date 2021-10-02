from sys import stdin
readline = stdin.readline

N = int(readline())

def solve():

    for _ in range(N):
        word = list(sorted(list(readline().strip())))
        print(''.join(word))
        while next_permutation(word):
            print(''.join(word))

def next_permutation(word):
    i = j = len(word) - 1

    while i > 0 and word[i - 1] >= word[i]:
        i -= 1

    if i == 0:
        return False
    
    while word[j] <= word[i - 1]:
        j -= 1

    word[i - 1], word[j] = word[j], word[i - 1]

    k = len(word) - 1

    while i < k:
        word[i], word[k] = word[k], word[i]
        i += 1
        k -= 1 

    return True

def swap(word, i, j):
    temp = word[i]
    word[i] = word[j]
    word[j] - temp

solve()