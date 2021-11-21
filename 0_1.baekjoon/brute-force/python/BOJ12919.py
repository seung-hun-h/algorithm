from sys import stdin
readline = stdin.readline

S = readline().strip()
T = readline().strip()
result = False
def solve():
    dfs(T[:])
    print(1 if result else 0)

def dfs(string):
    global result
    if len(string) == len(S):
        if string == S:
            result = True
        return

    if string[len(string) - 1] == 'A':
        dfs(string[:len(string) - 1])
    
    if string[0] != 'A':
        dfs(string[::-1][:len(string) - 1])

solve()