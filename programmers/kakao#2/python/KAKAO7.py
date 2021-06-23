import collections
def solution(record):
    
    ENTER_FORMAT = "%s님이 들어왔습니다."
    LEAVE_FORMAT = "%s님이 나갔습니다."
    
    format_dict = {"Enter": ENTER_FORMAT, "Leave": LEAVE_FORMAT}
    
    user_infos = collections.defaultdict(str)
    command_list = []
    
    for log in record:
        log_split = log.split(" ")
        
        if log_split[0] == "Enter":
            user_infos[log_split[1]] = log_split[2] 
            command_list.append([log_split[0], log_split[1]])
            
        elif log_split[0] == "Leave":
            command_list.append([log_split[0], log_split[1]])
            
        else:
            user_infos[log_split[1]] = log_split[2]
            
    return [format_dict[cmd[0]] % format(user_infos[cmd[1]]) for cmd in command_list]

"""
[카카오 2019 공채] 오픈채팅방
해결: O
시간: 16분
"""