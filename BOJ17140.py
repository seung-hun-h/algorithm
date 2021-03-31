from sys import stdin
readline = stdin.readline

r, c, k = map(int, readline().split())
_map = [list(map(int, readline().split())) for _ in range(3)]
ans = 0
r_size = 3
c_size = 3

def solve():
    global ans, _map, r_size, c_size

    while ans <= 100:
        if r <= r_size and c <= c_size and _map[r-1][c-1] == k:
            break
            
        ans += 1      
        
        if r_size >= c_size:
            temp = []
            for row in range(r_size):
                new_row = operation(_map[row])
                c_size = max(c_size, len(new_row))
                temp.append(new_row)

            if c_size > 100:
                c_size = 100
            for t in temp:
                while len(t) < c_size:
                    t.append(0)
                if len(t) > c_size:
                    t = t[:c_size]
            _map = temp

        else:
            temp = []
            new_r_size = r_size
            for col in range(c_size):
                column = []
                for row in range(r_size):
                    column.append(_map[row][col])

                new_col = operation(column)
                new_r_size = max(new_r_size, len(new_col))
                temp.append(new_col)
            
            r_size = new_r_size
            if r_size > 100:
                r_size = 100
            for t in temp:
                while len(t) < r_size:
                    t.append(0)
                if len(t) > r_size:
                    t = t[:r_size]

            trans_temp = [[0] * c_size for _ in range(r_size)]
            for col in range(c_size):
                for row in range(r_size):
                    trans_temp[row][col] = temp[col][row]
            
            _map = trans_temp
    
def operation(line):
    counts = [0] * 101
    _dict = {}
    
    for value in line:
        if value:
            counts[value] += 1

    for i in range(1, 101):
        if counts[i] == 0: continue
        if counts[i] not in _dict:
            _dict[counts[i]] = []
        _dict[counts[i]].append(i)
    
    temp = []
    for key in range(1, 101):
        if key in _dict:
            values = _dict[key]
            for v in values:
                temp.append(v)
                temp.append(key)

    return temp        

solve()
print(ans if ans <= 100 else -1)
