import java.util.*;

class KAKAO20 {
    public String solution(int n, int t, int m, String[] timetable) {
        int result = 0;
        int[] times = strToInt(timetable);
        int idx = 0;
        List<Integer> departed = new ArrayList<>();

        for (int i=0;i<n;i++) {
            departed.clear();
            int limitTime = 9 * 60 + i*t;

            for (int j=1;j<=m;j++) {
                if (idx >= times.length || times[idx] > limitTime)
                    break;
                departed.add(times[idx]);
                idx++;
            }
        }

        if (departed.size() < m) {
            result = 9 * 60 + (n - 1) * t;   
        } else {
            result = departed.get(departed.size()-1) - 1;
        }
        String answer = intToStr(result);
        return answer;
    }

    private String intToStr(int time) {
        String result = "";
        int hour = time / 60;
        int minute = time % 60;

        result += hour < 10 ? "0" + String.valueOf(hour) : String.valueOf(hour);
        result += ":";
        result += minute < 10 ? "0" + String.valueOf(minute) : String.valueOf(minute);

        return result;
    }

    private int[] strToInt(String[] timetable) {
        int[] result = new int[timetable.length];

        for(int i=0;i<timetable.length;i++) {
            String[] splitTime = timetable[i].split(":");

            int hour = Integer.parseInt(splitTime[0]) * 60;
            int minute = Integer.parseInt(splitTime[1]);

            result[i] = hour + minute;
        }
        Arrays.sort(result);       
        return result;
    }
}

/***
 * [카카오 2018 공채] 셔틀버스
 * 해결: O
 */