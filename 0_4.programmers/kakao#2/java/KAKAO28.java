import java.util.*;
public class KAKAO28 {
    class Page {
        int index, basic;
        double score;
        List<String> linkList;
        
        Page(int index, int basic, List<String> linkList, double score) {
            this.index = index;
            this.basic = basic;
            this.linkList = linkList;
            this.score = score;
        }
        
        public String toString() {
            return "index = " + index + " score = " + score + " basic = " + basic;
        }
        
    }
    public int solution(String word, String[] pages) {
        int wSize = word.length();
        List<Page> pageList = new ArrayList<>();
        Map<String, Integer> pageMap = new HashMap<>();
        word = word.toLowerCase();
        for (int i = 0; i < pages.length; i++) {
            String s = pages[i].toLowerCase();
            
            // url 찾기
            int left = 0, mid = 0, right = 0;
            
            while (mid <= left) {
                left = s.indexOf("<meta", left + 1);
                right = s.indexOf(">", left);
                mid = s.lastIndexOf("https://", right);
            }
            right = s.indexOf("\"", mid + 1);
            String url = s.substring(mid, right);
            int basic = 0;
            left = s.indexOf("<body>");
            for (int start=left;;) {
                start = s.indexOf(word, start + 1);
                
                if (start == -1)
                    break;
                
                if (!Character.isLetter(s.charAt(start - 1)) && !Character.isLetter(s.charAt(start + wSize)))
                    basic++;
            
                start += wSize;
            }
            List<String> links = new ArrayList<>();
            for (int start=left;;) {
                start = s.indexOf("<a href=", start + 1);
                right = s.indexOf("\">", start);
                mid = s.lastIndexOf("https://", right);                
                if (start == -1)
                    break;
                if (mid != -1)
                    links.add(s.substring(mid, right));
                start = right;
            }
            
            Page p = new Page(i, basic, new ArrayList<>(links), (double)basic);
            pageList.add(p);
            pageMap.put(url, i);
        }
        
        for (int i = 0; i < pageList.size(); i++) {
            Page page = pageList.get(i);
            for (String adj : page.linkList) {
                Integer idx = pageMap.get(adj);
                if (idx != null) {
                    pageList.get(idx).score += (double)page.basic / page.linkList.size();
                }
            }
        }
        Collections.sort(pageList, new Comparator<>(){
            public int compare(Page p1, Page p2) {
                if (p1.score != p2.score) {
                    return Double.compare(p2.score, p1.score);
                } else {
                    return p1.index - p2.index;
                }
            }
        });
        
        return pageList.get(0).index;
    }
    public static void main(String[] args) {
        String word = "Muzi";
        String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
        System.out.println(new KAKAO28().solution(word, pages));
    }
}
/**
 * [카카오 2019 공채] 매칭 점수
 * 해결: X
 */