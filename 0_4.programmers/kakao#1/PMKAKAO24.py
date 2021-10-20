from datetime import timedelta
def solution(n, t, m, timetable):
    _timetable = [int(t.split(":")[0])*60+int(t.split(":")[1])\
        for t in timetable]
    _timetable.sort()

    ans = i = 0
    time = 9 * 60
    for _ in range(n):
        cnt = 0 # 버스에 타는 크루원 수
        while cnt < m and i < len(_timetable) and _timetable[i] <= time:
            i += 1
            cnt += 1

        # 버스에 자리가 남은 경우
        if cnt < m:
            ans = time 
        else:
        # 버스에 자리가 없는 경우
        # 마지막 탑승 인원 보다 1분 빠르게 도착
            ans = _timetable[i-1] - 1
        time += t
    
    return str(ans//60).zfill(2) + ":" + str(ans%60).zfill(2)

res = solution(10, 60, 45, ["23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"])
print(res)