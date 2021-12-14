def solution(s):
    if len(s) == 1:
        return 1

    answer = [] 
    
    for i in range(1, len(s) // 2 + 1):
        compressed = ""
        cnt = 1
        tmp = s[:i]

        for j in range(i, len(s), i):
            if tmp == s[j:i+j]:
                cnt += 1
            else:
                if cnt != 1:
                    compressed = compressed + str(cnt) + tmp
                else:
                    compressed = compressed + tmp

                tmp = s[j:i+j]
                cnt = 1

        if cnt != 1:
            compressed = compressed + str(cnt) + tmp
        else:
            compressed = compressed + tmp
        
        answer.append(len(compressed))

    return min(answer)

print(solution("aabbaccc"))
print(solution("ababcdcdababcdcd"))
print(solution("abcabcdede"))
print(solution("abcabcabcabcdededededede"))
print(solution("xababcdcdababcdcd"))
