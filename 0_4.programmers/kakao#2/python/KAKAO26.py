from collections import defaultdict

def solution(play_time, adv_time, logs):
    play_time = convert(play_time)
    adv_time = convert(adv_time)
    total_second = defaultdict(int)
    
    for log in logs:
        log_start, log_end = log.split("-")
        total_second[convert(log_start)] += 1
        total_second[convert(log_end)] -= 1
    
    for i in range(1, play_time):
        total_second[i] += total_second[i - 1]
        
    current_cnt = 0
    for i in range(1, adv_time):
        current_cnt += total_second[i]
        
    max_cnt = current_cnt
    max_idx = 0
    
    for i in range(adv_time, play_time):
        current_cnt = current_cnt + total_second[i] - total_second[i - adv_time]
        
        if current_cnt > max_cnt:
            max_cnt = current_cnt
            max_idx = i - adv_time + 1
            
    answer = '%02d:%02d:%02d' % (max_idx / 3600, (max_idx / 60) % 60, max_idx % 60)
    return answer

def convert(time):
    h, m, s  = map(int, time.split(":"))
    return h * 60 * 60 + m * 60 + s

'''
[카카오 2021 공채] 광고 삽입
해결: X
'''