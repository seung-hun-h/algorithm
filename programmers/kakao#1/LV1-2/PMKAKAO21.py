def solution(n, t, m, p):
    notation = "0123456789ABCDEF"
    _str = ''
    i = 0
    while len(_str) < m*t:
        trans = trans_numeral_system(i, n, notation)
        _str += trans 
        i += 1
    _str = _str[:m*t]
    return _str[p-1::m]

def trans_numeral_system(number, base, notation):
    q, r = divmod(number, base)
    n = notation[r]
    return trans_numeral_system(q, base, notation) + n if q else n
n = 16
t = 16
m = 2
p = 1
solution(n, t, m, p)