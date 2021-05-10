def solution(code, day, data):
    answer = []
    for d in data:
        p, c, t = d.split()
        if c.split("=")[1] == code and t.split("=")[1][:-2] == day:
            answer.append([p, t])
    return [int(p[0].split("=")[1]) for p in sorted(answer, key= lambda x : x[1].split("=")[1])]

a = "012345"
b = "20190620"
c = ["price=80 code=987654 time=2019062113","price=90 code=012345 time=2019062014","price=120 code=987654 time=2019062010","price=110 code=012345 time=2019062009","price=95 code=012345 time=2019062111"]
solution(a, b, c)