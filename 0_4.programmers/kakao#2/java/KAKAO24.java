import java.util.*;
class KAKAO24 {
    private static final int BUILD = 1;
    public class Structure {
        int x;
        int y;
        int type;
        
        Structure(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Structure) {
                Structure other = (Structure) obj;
                return x == other.x && y == other.y && type == other.type;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
        
        @Override
        public String toString() {
            return "x: " + x + " y: " + y + " type: " + type;
        }
    }

    public int[][] solution(int n, int[][] build_frame) {
        Set<Structure> result = new HashSet<>();
        
        for (int[] cmd : build_frame) {
            Structure structure = new Structure(cmd[0], cmd[1], cmd[2]);
            if (cmd[3] == BUILD) {
                result.add(structure);
                
                if (!isValid(result)) {
                    result.remove(structure);
                }
                
            } else {
                result.remove(structure);
                if (!isValid(result))
                    result.add(structure);
            }
            
        }
        int[][] answer = new int[result.size()][3];
        Iterator<Structure> iter = result.iterator();
        
        for (int i=0;i<result.size();i++) {
            Structure st = iter.next();
            answer[i] = new int[] {st.x, st.y, st.type};
        }
        
        Arrays.sort(answer, new Comparator<>(){
            public int compare(int[] a1, int[] a2) {
                if (a1[0] != a2[0]) {
                    return a1[0] - a2[0];
                } else if (a1[1] != a2[1]) {
                    return a1[1] - a2[1];
                } else {
                    return a1[2] - a2[2];
                }
            } 
        });
        return answer;
    }
    
    private boolean isValid(Set<Structure> result) {
        Iterator<Structure> iter = result.iterator();
        while (iter.hasNext()) {
            Structure st = iter.next();
            int x = st.x, y = st.y;
                        
            if (st.type == 0) {
                if (st.y == 0 || result.contains(new Structure(x, y-1, 0)) || 
                    result.contains(new Structure(x, y, 1)) || result.contains(new Structure(x-1, y, 1)))
                    continue;
                return false;
            } else {
                if (result.contains(new Structure(x, y-1, 0)) || result.contains(new Structure(x+1, y-1, 0))
                  || (result.contains(new Structure(x-1, y, 1)) && result.contains(new Structure(x+1, y, 1))))
                    continue;
                return false;
            }
        }
        return true;
    }
}
/***
 * [카카오 2020 공채] 기둥과 보 설치
 * 해결: X
 */