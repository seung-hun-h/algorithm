import datetime

def solution(lines):
    logs = []
    for line in lines:
        yMd, hms, ss = line.split()
        y, M, d = map(int, yMd.split("-"))
        h, m, s = hms.split(":")
        h, m = map(int, [h, m])
        sec, msec = map(int, s.split("."))
        ss = float(ss.split("s")[0])

        logs.append([datetime.datetime(y, M, d, h, m, sec, msec*1000), ss])
    
    _max = 0
    for i in range(len(logs)):
        cnt = 1
        cur_range = logs[i][0] + datetime.timedelta(seconds=0.999)
        for j in range(i+1, len(logs)):
            next_end = logs[j][0]
            next_start = next_end - datetime.timedelta(seconds=logs[j][1]) + datetime.timedelta(seconds=0.001)
            if next_start > cur_range: continue
            cnt += 1
        
        _max = max(_max, cnt)
    return _max