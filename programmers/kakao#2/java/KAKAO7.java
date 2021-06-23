import java.util.*;
public class KAKAO7 {
    class Solution {
        private static final String ENTER_FORMAT = "%s님이 들어왔습니다.";
        private static final String LEAVE_FORMAT = "%s님이 나갔습니다.";
        
        private Map<String, User> userInfo = new HashMap<String, User>();
        
        private static class User {
            private String id;
            private String nickname;
            
            User(String id, String nickname) {
                this.id = id;
                this.nickname = nickname;
            }
        }
        
        private static class Command {
            private String command;
            private String userId;
            
            Command(String command, String userId) {
                this.command = command;
                this.userId = userId;
            }
        }
        
        public String[] solution(String[] record) {
            List<Command> commandList = new ArrayList<>();
            
            for (String log : record) {
                String[] logSplit = log.split(" ");
                
                if (logSplit[0].equals("Enter")) {
                    userInfo.put(logSplit[1], new User(logSplit[1], logSplit[2]));
                    commandList.add(new Command(logSplit[0], logSplit[1]));
                } else if (logSplit[0].equals("Change")) {
                    userInfo.get(logSplit[1]).nickname = logSplit[2];
                } else {
                    commandList.add(new Command(logSplit[0], logSplit[1]));
                }
            }
            
            
            return commandList.stream()
                .map(cmd -> String.format(cmd.command.equals("Enter") ? ENTER_FORMAT : LEAVE_FORMAT, userInfo.get(cmd.userId).nickname))
                .toArray(ary -> new String[commandList.size()]);
        }
    }
}
/***
 * [카카오 2019 공채] 오픈 채팅방
 * 해결: O
 * 시간: 16분
 * 자바는 객체!객체!객체!!!!! 
 */