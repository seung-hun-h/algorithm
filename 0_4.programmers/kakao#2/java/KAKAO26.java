class KAKAO26 {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = mapToSecond(play_time);
        int advTime = mapToSecond(adv_time);
        long[] playCnt = new long[playTime + 1];
        
        for (String log : logs) {
            int start = mapToSecond(log.split("-")[0]);
            int end = mapToSecond(log.split("-")[1]);
            
            // 시작 시간과 끝나는 시간 마킹
            playCnt[start]++;
            playCnt[end]--;
        }
        
        // 누적 합
        for (int i = 1;i < playTime;i++) {
            playCnt[i] += playCnt[i - 1];
        }
        
        
        long currentCnt = 0L;
        for (int i = 0; i < advTime; i++) {
            currentCnt += playCnt[i];    
        }
        
        long maxCnt = currentCnt, maxIdx = 0;
        for (int right = advTime; right < playTime; right++) {
            currentCnt = currentCnt + playCnt[right] - playCnt[right - advTime];
            
            if (currentCnt > maxCnt) {
                maxCnt = currentCnt;
                maxIdx = right - advTime + 1;
            }
        }
        
        return mapToString(maxIdx);
    }
    
    private int mapToSecond(String time) {
        int hour = Integer.parseInt(time.split(":")[0]) * 60 * 60;
        int minuet = Integer.parseInt(time.split(":")[1]) * 60;
        int second = Integer.parseInt(time.split(":")[2]);
        
        return hour + minuet + second;
    }
    
    private String mapToString(long time) {
        long hour = time / (60 * 60);
        long minuet = (time / 60) % 60;
        long second = time % 60;
        
        return String.format("%02d:%02d:%02d", hour, minuet, second);
    }
}
/**
 * [카카오 2021 공채] 광고 삽입
 * 해결: X
 * 
 */