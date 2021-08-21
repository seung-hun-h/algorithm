class Page:
    def __init__(self, idx, basic, score, link_list):
        self.idx = idx
        self.basic = basic
        self.score = score
        self.link_list = link_list
        
def solution(word, pages):
    word = word.lower()
    w_size = len(word)
    page_list = []
    page_map = dict()
    
    for i, page in enumerate(pages):
        s = page.lower()
        
        left, mid, right = 0, 0, 0
        while mid <= left:
            left = s.find("<meta", left + 1)
            right = s.find(">", left)
            mid = s.find("https://", left, right)
        
        right = s.find('"', mid)
        url = s[mid:right]
        
        left = s.find("<body>")
        basic, start = 0, left
        while True:
            start = s.find(word, start + 1)
                
            if start == -1:
                break
                
            if not s[start - 1].isalpha() and not s[start + w_size].isalpha():
                basic += 1
            
            start += w_size
        
        links, start = [], left
        while True:
            start = s.find("<a href=", start + 1)
            if start == -1:
                break
                
            right = s.find("\">", start)
            mid = s.find("https://", start, right)
            
            if mid != -1:
                links.append(s[mid:right])
            
            start = right
        
        p = Page(i, basic, basic, links)
        page_list.append(p)
        page_map[url] = i

        
    for page in page_list:
        for adj in page.link_list:
            if adj in page_map:
                idx = page_map[adj]
                page_list[idx].score += page.basic / len(page.link_list)
    
    return sorted(page_list, key=lambda x : [-x.score, x.idx])[0].idx

'''
[카카오 2019 공채] 매칭 점수
해결: X
'''