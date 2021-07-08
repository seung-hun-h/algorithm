def solution(m, musicinfos):
    m = process(m)
    max_play = 0
    answer = "(None)"
    for musicinfo in musicinfos:
        start, end, title, info = musicinfo.split(",")
        
        info = process(info)
        
        start_h, start_m = map(int, start.split(":"))
        end_h, end_m = map(int, end.split(":"))
        
        times = end_h * 60 + end_m - start_h*60 - start_m
        
        music = info * (times // len(info)) + info[:times % len(info)]
        
        if m in music:
            if max_play < times:
                answer = title
                max_play = times
    
    return answer

def process(str):
    return str.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a")

"""
[2018 카카오 공채] 방금 그 곡
해결: O
"""