def solution(m, musicinfos):
    m = m.replace("A#", "a").replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g")
    answer = '(None)'
    max_play = 0
    for info in musicinfos:
        start, end, title, music = info.split(",")

        # Calculate play time
        # Hours > Minutes
        start = int(start.split(":")[0])*60 + int(start.split(":")[1])
        end = int(end.split(":")[0])*60 + int(end.split(":")[1])
        diff = end - start
        music = music.replace("A#", "a").replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g")   
        play = music*(diff // len(music)) + music[:diff%len(music)]

        if m in play:
            if max_play < diff:
                max_play = diff
                answer = title
    return answer


m = "ABCDEFG"
M = ["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]
solution(m, M)