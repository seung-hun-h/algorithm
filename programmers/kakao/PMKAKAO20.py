def solution(files):
    process = []
    for file in files:
        for i in range(len(file)):
            # Split head, number, tail
            if file[i].isdigit():
                head = file[:i]
                j = i+1
                while j < len(file) and file[j].isdigit():
                    j += 1
                number, tail = file[i:j], file[j:]
                process.append([head, number, tail])
                break
    # sort
    answer = ["".join(p) for p in sorted(process, key=lambda x: (x[0].lower(), int(x[1])))]
    return answer

res = solution(["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"])
print(res)