from sys import stdin
readline = stdin.readline

def solve():
    alphas = ['a', 'b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w', 'x', 'y', 'z']
    line = readline().strip()
    for alpha in alphas:
        print(line.find(alpha), end=" ")

solve()