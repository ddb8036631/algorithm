def solution(record):
    answer = []
    dict = {}
    
    for command in record:
        splited = command.split()
        if len(splited) == 3:
            dict[splited[1]] = splited[2]

    for command in record:
        splited = command.split()
        if splited[0] == "Enter":
            answer.append("%s님이 들어왔습니다." % dict[splited[1]])
        elif splited[0] == "Leave":
            answer.append("%s님이 나갔습니다." % dict[splited[1]])

    
    return answer

print(solution(["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]))
